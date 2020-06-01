package com.bj.mapper;

import com.bj.pojo.Syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SyslogMapper {

    @Select("select * from tb_syslog")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "ip", property = "ip"),
            @Result(column = "url", property = "url"),
            @Result(column = "method", property = "method"),
            @Result(column = "visitTime", property = "visitTime"),
            @Result(column = "executionTime", property = "executionTime"),
            @Result(column = "errorMessage", property = "errorMessage")
    })
    List<Syslog> selectAllSyslog();

    @Insert("Insert into tb_syslog values (default,#{username},#{ip},#{url},#{method},#{visitTime},#{executionTime},#{errorMessage})")
    int insertSyslog(Syslog syslog);
}
