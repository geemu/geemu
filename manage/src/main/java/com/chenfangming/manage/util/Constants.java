package com.chenfangming.manage.util;

import java.nio.charset.Charset;

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
        /** UTF-8 **/
        Charset UTF_8 = Charset.forName(UTF_8_VALUE);
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

}
