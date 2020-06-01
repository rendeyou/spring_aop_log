package com.bj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Syslog {
    private int id;
    private String username;
    private String ip;
    private String url;
    private String method;
    private Date visitTime;
    private Long executionTime;
    private String errorMessage;
}
