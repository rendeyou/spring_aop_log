package com.bj.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class ConfigInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Spring容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppRootConfig.class};
    }

    // SpringMvc容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppMvcCongig.class};
    }

    // "/*"拦截所有
    // "/"拦截所有除了jsp
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 字符编码过滤器
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{characterEncodingFilter};
    }
}
