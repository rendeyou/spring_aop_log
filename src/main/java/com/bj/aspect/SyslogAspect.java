package com.bj.aspect;

import com.bj.pojo.Syslog;
import com.bj.pojo.User;
import com.bj.service.SyslogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Controller
public class SyslogAspect {
    //开始时间
    private Long visitTime;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SyslogService syslogService;

    //切点
    @Pointcut("@annotation(com.bj.aspect.SyslogAnnotation)")
    public void pointCut() {

    }

    //环绕通知
    @Around("pointCut()")
    public Object aroundSyslog(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[正常日志记录]进入环绕通知");
        //开始时间
        visitTime = System.currentTimeMillis();
        //切点执行
        Object result = joinPoint.proceed();
        //正常日志记录
        Syslog syslog = null;
        try {
            syslog = handleAroundSyslog(joinPoint);
            syslog.setErrorMessage(null);
            //请求30接口
            if (syslog != null) {
                System.out.println("[正常日志记录]请求30接口");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //存入本地数据库
            if (syslog != null) {
                syslogService.insertSyslog(syslog);
            }
        }
        return result;
    }

    //异常通知
    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void throwingSyslog(JoinPoint joinPoint, Throwable error) {
        System.out.println("[异常日志记录]进入异常通知");
        //异常日志记录
        Syslog syslog = null;
        try {
            syslog = handleAroundSyslog(joinPoint);
            String errorMessage = error.getMessage();
            if (errorMessage != null && errorMessage.length() > 1000) {
                errorMessage = errorMessage.substring(0, 1000);
            }
            syslog.setErrorMessage(errorMessage);
            //请求30接口
            if (syslog != null) {
                System.out.println("[异常日志记录]请求30接口");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //存入本地数据库
            if (syslog != null) {
                syslogService.insertSyslog(syslog);
            }
        }
    }

    private Syslog handleAroundSyslog(JoinPoint joinPoint) {
        Syslog syslog = new Syslog();
        //开始时间
        syslog.setVisitTime(new Date(visitTime));
        //结束时间
        syslog.setExecutionTime(System.currentTimeMillis() - visitTime);
        //访问的用户
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            syslog.setUsername(user.getUsername());
        }
        //访问的IP
        syslog.setIp(this.FindRemoteAddr(request));
        //访问的URL
        String url = request.getRequestURL().toString();
        if (url != null) {
            syslog.setUrl(url);
        }
        //反射
        Class<?> clazz = joinPoint.getTarget().getClass();
        //访问的注解
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        SyslogAnnotation syslogAnnotation = method.getAnnotation(SyslogAnnotation.class);
        if (syslogAnnotation != null) {
            String optionFunction = syslogAnnotation.optionFunction();
            System.out.println("optionFunction = " + optionFunction);
            String optionExplain = syslogAnnotation.optionExplain();
            System.out.println("optionExplain = " + optionExplain);
        }
        //访问的方法
        if (method != null) {
            syslog.setMethod("[类名]" + clazz.getName() + "[方法名]" + method.getName());
        }
        return syslog;
    }

    // 获取用户IP地址
    private String FindRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

    /**
     * 获取用户真实IP地址
     * 不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址,
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值
     */
    private String FindRemoteAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.indexOf(",") != -1) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }
}
