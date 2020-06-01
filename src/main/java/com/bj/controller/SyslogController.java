package com.bj.controller;

import com.bj.pojo.Syslog;
import com.bj.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SyslogController {
    @Autowired
    private SyslogService syslogService;

    @RequestMapping("/selectAllSyslog")
    @ResponseBody
    public List<Syslog> selectAllSyslog() {
        List<Syslog> syslogList = syslogService.selectAllSyslog();
        return syslogList;
    }
}
