package com.bj.controller;

import com.bj.aspect.SyslogAnnotation;
import com.bj.pojo.PageBean3;
import com.bj.pojo.User;
import com.bj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// IoC注解
@Controller
public class UserController {
    // DI注解
    @Autowired
    private UserService userService;

    /**
     * 分页查询用户列表
     *
     * @param id       查询条件用户ID
     * @param username 查询条件用户名
     * @param page     当前页
     * @param size     每页显示的记录数
     * @param model    请求作用域
     * @return
     * @throws Exception
     */
    // mvc注解
    @RequestMapping("/userList")
    @SyslogAnnotation(optionFunction = "查", optionExplain = "用户列表")
    public String userList(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "page", required = false, defaultValue = "1") String page,
            @RequestParam(value = "size", required = false, defaultValue = "3") String size,
            Model model) throws Exception { //mvc注解
        // 封装分页对象
        PageBean3<User> p = new PageBean3<>(page, size);
        // 调用后台方法
        p = userService.userListService(p, id, username);
        // 请求作用域
        model.addAttribute("p", p);
        model.addAttribute("id", id); //记录查询条件
        model.addAttribute("username", username); //记录查询条件
        // 跳转的页面
        return "user/userlist";
    }

    /**
     * 用户注册
     *
     * @param user    用户对象
     * @param confirm 确认密码
     * @param model   请求作用域
     * @return
     * @throws Exception
     */
    @RequestMapping("/regist")
    @SyslogAnnotation(optionFunction = "曾", optionExplain = "用户注册")
    public String regist(User user, String confirm, Model model) throws Exception {
        try {
            // 调用后台方法
            userService.registService(user, confirm);
            // 跳转的页面
            return "redirect:/index.jsp"; //响应重定向到登录页面
        } catch (Exception e) {
            // 请求作用域
            model.addAttribute("msg", "用户注册失败");
            // 跳转的页面
            return "forward:/regist.jsp"; //请求转发到注册页面
        }
    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @param req      请求作用域
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    @SyslogAnnotation(optionFunction = "查", optionExplain = "用户登录")
    public String login(String username, String password, HttpServletRequest req) throws Exception {
        // 调用后台方法
        User user = userService.loginService(username, password);
        // 判断
        if (user == null) {
            req.getSession().setAttribute("msg", "用户名或者密码错误");
            return "forward:/index.jsp";
        }
        // 请求作用域
        req.getSession().setAttribute("user", user);
        req.getSession().setAttribute("username", user.getUsername());
        // 跳转控制器
        return "redirect:/toMain";
    }

    /**
     * 用户退出登录
     *
     * @param httpSession
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) throws Exception {
        httpSession.invalidate();
        return "redirect:/index.jsp";
    }

    /**
     * 根据用户IDS批量删除选中用户
     *
     * @param ids 用户IDS
     * @return
     * @throws Exception
     */
    @RequestMapping("/delByIds")
    @SyslogAnnotation(optionFunction = "删", optionExplain = "批量删除选中用户")
    public String delByIds(String ids) throws Exception {
        try {
            // 调用后台方法
            userService.delByIdsService(ids);
            // 响应重定向到分页查询控制器
            return "redirect:/userList";
        } catch (Exception e) {
            // 请求转发到分页查询控制器
            return "forward:/userList";
        }
    }

    /**
     * 根据用户ID查询用户详情(点击超链接查询用户详情)
     *
     * @param id    用户ID
     * @param model 请求作用域
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById")
    @SyslogAnnotation(optionFunction = "查", optionExplain = "点击超链接查询用户详情")
    public String findById(Integer id, Model model) throws Exception {
        // 调用后台方法
        User user = userService.findByIdService(id);
        // 请求作用域
        model.addAttribute("user", user);
        // 跳转的页面
        return "user/userdetail";
    }

    /**
     * 批量导入用户
     *
     * @param userFile 文件
     * @param model    请求作用域
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addUserBatch", method = RequestMethod.POST)
    @SyslogAnnotation(optionFunction = "曾", optionExplain = "批量导入用户")
    public String addUserBatch(MultipartFile userFile, Model model) throws Exception {
        try {
            // 调用后台方法
            userService.addUserBatch(userFile);
            // 跳转控制器
            return "redirect:/userList";
        } catch (Exception e) {
            e.printStackTrace();
            // 请求作用域
            model.addAttribute("msg", "批量导入用户失败");
            // 跳转的页面
            return "user/addUserBatch";
        }
    }
}
