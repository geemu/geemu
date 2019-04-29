package com.chenfangming.common;

import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;

/**
 * IO工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-29 22:30
 */
@Slf4j
public final class IoHelper {

    /**
     * 关闭Closeable
     * 关闭失败不会抛出异常
     * @param closeable 被关闭的对象
     */
    public static void close(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (Exception e) {
                log.error("关闭Closeable异常：{}{}", e, "");
            }
        }
    }

    /**
     * 关闭
     * 关闭失败不会抛出异常
     * @param closeable 被关闭的对象
     */
    public static void close(AutoCloseable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (Exception e) {
                log.error("关闭AutoCloseable异常：{}{}", e, "");
            }
        }
    }

}
