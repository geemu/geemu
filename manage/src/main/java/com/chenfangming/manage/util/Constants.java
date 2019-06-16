package com.chenfangming.manage.util;

/**
 * 常量
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-07 17:16
 */
public interface Constants {

    /**
     * 系统常量
     */
    interface System {
        /** UTF-8 **/
        String UTF_8_VALUE = "UTF-8";
        /** &符号 **/
        String AND = "&";
        /** 等于 **/
        String EQUAL = "=";
        /** 问号 **/
        String WHAT = "?";
        /** 下划线 **/
        String UNDER_LINE = "_";
        /** 中划线 **/
        String MIDDLE_LINE = "-";
        /** 空字符串 **/
        String EMPTY_STRING = "";
    }

    /**
     * 自定义话术值
     */
    interface Tips {
        String NAME_NOT_BLANK = "用户名不为空";
        String PASSWORD_NOT_BLANK = "密码不为空";
    }

}
