package com.chenfangming.manage.util;

/**
 * 常量
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-07 17:16
 */
public interface Constants {

    /**
     * 常量值
     */
    interface Value {
        /** UTF-8 **/
        String UTF_8_VALUE = "UTF-8";
        /** 空字符串 **/
        String EMPTY_STRING = "";
        /** 未知 **/
        String UNKNOW = "UNKNOW";
        /** 英文逗号 **/
        String COMMA_EN = ",";
        /** -1 **/
        Integer NUMBER_INTEGER_NEGATIVE_1 = -1;
        /** 0 **/
        Integer NUMBER_INTEGER_0 = 0;
    }

    /**
     * 自定义话术值
     */
    interface Tips {
        String NAME_NOT_BLANK = "用户名不为空";
        String PASSWORD_NOT_BLANK = "密码不为空";
    }

}
