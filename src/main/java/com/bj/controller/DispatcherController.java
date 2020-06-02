package com.bj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // IoC注解
public class DispatcherController {

    /**
     * 跳转到主页面的控制器
     */
    @RequestMapping("/toMain") // mvc注解
    public String toMain() {
        return "main";
    }

    /**
     * 跳转到commons目录的控制器
     */
    @RequestMapping("/commons/{page}") // mvc注解
    public String toCommons(@PathVariable String page) { //mvc注解
        return "commons/" + page;
    }

    /**
     * 跳转到user目录的控制器
     */
    @RequestMapping("/user/{page}") // mvc注解
    public String toUser(@PathVariable String page) { //mvc注解
        return "user/" + page;
    }
}
