package com.bj.config;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// Spring容器的配置文件
@Configuration
@ComponentScan(
        basePackages = {"com.bj"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        }
)
@EnableAspectJAutoProxy
@Import(MybatisConfig.class) // Spring容器的配置文件之Mybatis
@EnableScheduling //开启定时，定时任务
@EnableAsync //开启异步，定时任务
public class AppRootConfig {
}
