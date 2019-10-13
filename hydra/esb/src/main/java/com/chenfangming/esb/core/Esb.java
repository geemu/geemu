package com.chenfangming.esb.core;

/**
 * Esb
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-13 23:43
 */
public interface Esb<H, B> {

    /**
     * 获取Head
     * @return Head
     */
    H getHead();

    /**
     * 设置Head
     * @param head head
     */
    void setHead(H head);

    /**
     * 获取Body
     * @return Body
     */
    B getBody();

    /**
     * 设置Body
     * @param body body
     */
    void setBody(B body);

}
