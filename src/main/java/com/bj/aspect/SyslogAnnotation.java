package com.bj.aspect;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
// 自定义注解
public @interface SyslogAnnotation {
    // 比如：增删改查
    String optionFunction() default "";

    // 比如：添加用户
    String optionExplain() default "";
}
