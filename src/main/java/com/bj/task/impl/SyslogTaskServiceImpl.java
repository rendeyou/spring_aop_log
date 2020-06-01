package com.bj.task.impl;

import com.bj.pojo.Syslog;
import com.bj.service.SyslogService;
import com.bj.task.SyslogTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SyslogTaskServiceImpl implements SyslogTaskService {

    @Autowired
    private SyslogService syslogService;

    @Override
    //@Scheduled(cron = "*/10 * * * * ?")
    @Scheduled(cron = "* * */10 * * ?")
    @Async
    public Boolean syslogTaskTo30() {
        //查询本地数据库
        List<Syslog> syslogList = syslogService.selectAllSyslog();
        syslogList.forEach(syslog -> {
            System.out.println(syslog);
        });
        //请求30接口
        return true;
    }
}
