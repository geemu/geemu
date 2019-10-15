package com.chenfangming.esb.core.sign;

/**
 * Xml
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-13 23:43
 */
public interface Xml<H extends EsbHead, B extends EsbBody> {

    H getHead();

    void setHead(H head);

    B getBody();

    void setBody(B body);

}
