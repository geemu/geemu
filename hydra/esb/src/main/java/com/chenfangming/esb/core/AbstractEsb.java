package com.chenfangming.esb.core;


/**
 * 请求
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-17 23:26
 */
public abstract class AbstractEsb<Head extends EsbHeadStyle, Body extends EsbBodyStyle> implements Esb<Head, Body> {

    /**
     * 获取Head
     * @return Head
     */
    @Override
    public abstract Head getHead();

    /**
     * 设置Head
     * @param head head
     */
    @Override
    public abstract void setHead(Head head);

    /**
     * 获取Body
     * @return B
     */
    @Override
    public abstract Body getBody();

    /**
     * 设置Body
     * @param body body
     */
    @Override
    public abstract void setBody(Body body);

}
