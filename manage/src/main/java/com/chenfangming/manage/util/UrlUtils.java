package com.chenfangming.manage.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * URL工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-07 17:35
 */
@Slf4j
public final class UrlUtils {

    /**
     * 对字符串进行URL编码,编码失败返回空字符串
     * @param url 需要编码的字符串
     * @return 编码后的字符串
     */
    public static String encode(String url) {
        try {
            return URLEncoder.encode(url, Constants.System.UTF_8_VALUE);
        } catch (UnsupportedEncodingException e) {
            log.error("URL:{},编码异常:{},返回空字符串", url, e);
            return Constants.System.EMPTY_STRING;
        }
    }

}
