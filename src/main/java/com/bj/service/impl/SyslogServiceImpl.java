package com.bj.service.impl;

import com.bj.mapper.SyslogMapper;
import com.bj.pojo.Syslog;
import com.bj.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SyslogServiceImpl implements SyslogService {
    @Autowired
    private SyslogMapper syslogMapper;

    @Override
    public List<Syslog> selectAllSyslog() {
        return syslogMapper.selectAllSyslog();
    }

    @Override
    public int insertSyslog(Syslog syslog) {
        return syslogMapper.insertSyslog(syslog);
    }
}
