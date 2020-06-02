package com.bj.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    // 工具类
    private DateUtil() {
    }

    /**
     * 字符串格式转成日期格式
     *
     * @param date 字符串格式
     * @return 日期格式
     */
    public static Date str2Date(String date) {
        // properties-lang3-3.9.jar
        if (StringUtils.isBlank(date)) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
