package com.chenfangming.esb.core.impl;

import com.chenfangming.esb.core.sign.EsbBodyStyle;
import com.chenfangming.esb.core.sign.EsbHeadStyle;
import com.chenfangming.esb.core.sign.Xml;

/**
 * Esb
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-15 22:56
 */
public abstract class AbstractEsb<H extends EsbHeadStyle, B extends EsbBodyStyle> implements Xml<H, B> {

    public abstract H getHead();

    public abstract void setHead(H head);

    public abstract B getBody();

    public abstract void setBody(B body);

}
