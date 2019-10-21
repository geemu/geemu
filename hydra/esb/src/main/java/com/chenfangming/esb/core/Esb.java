package com.chenfangming.esb.core;

/**
 * Esb接口规范
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-17 23:24
 */
public interface Esb<Head, Body> {

    /**
     * 获取Head
     * @return Head
     */
    Head getHead();

    /**
     * 设置Head
     * @param head head
     */
    void setHead(Head head);

    /**
     * 获取Body
     * @return B
     */
    Body getBody();

    /**
     * 设置Body
     * @param body body
     */
    void setBody(Body body);

}
