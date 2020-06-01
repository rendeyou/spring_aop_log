package com.bj.service;

import com.bj.pojo.Syslog;

import java.util.List;

public interface SyslogService {

    List<Syslog> selectAllSyslog();

    int insertSyslog(Syslog syslog);
}
