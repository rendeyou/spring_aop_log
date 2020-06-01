package com.bj.util;

import java.security.MessageDigest;

/**
 * 调用digest加密方法（参数和返回值都是字节数组，返回值字节数组长度固定为16）
 * 将字节数组转换成十六进制的字符串,1个字节转换成2个十六进制的字符串（4位0000-1111相当于十六进制0-F的一个字符串，一个字节8位相当于两个字符串，字节数组长度16拼接成十六进制字符串长度32）
 */
public class Md5Util {
    // 工具类
    private Md5Util() {
    }

    /**
     * 密码加密
     *
     * @param password 明文
     * @return 密文
     */
    public static String md5(String password) throws Exception {
        // 获取MessageDigest对象
        MessageDigest md = MessageDigest.getInstance( "MD5" );
        // 调用digest加密方法
        byte[] temp = md.digest( password.getBytes() );
//        System.out.println( Arrays.toString(temp));
//        System.out.println("temp.length="+temp.length);
        // 将字节数组转换成十六进制的字符串
        StringBuilder builder = new StringBuilder();
        for (byte b : temp) {
            // 解决负号问题
            String s = Integer.toHexString( b & 0xff );
//            System.out.println(s);
            // 解决补零问题
            if (s.length() == 1) {
                builder.append( 0 );
            }
            builder.append( s );
        }
        return builder.toString();
    }
}
