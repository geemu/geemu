package com.chenfangming.esb.core.sign;

import com.chenfangming.esb.core.impl.sign.EsbBody;
import com.chenfangming.esb.core.impl.sign.EsbHead;

/**
 * Esb
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-15 22:56
 */
public abstract class AbstractEsb<H extends EsbHead, B extends EsbBody> implements Xml<H, B> {

    public abstract H getHead();

    public abstract void setHead(H head);

    public abstract B getBody();

    public abstract void setBody(B body);

}
