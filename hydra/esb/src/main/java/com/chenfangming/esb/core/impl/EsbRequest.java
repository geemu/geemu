package com.chenfangming.esb.core.impl;

import com.chenfangming.esb.core.sign.EsbBody;
import com.chenfangming.esb.core.sign.EsbHead;
import com.chenfangming.esb.core.sign.Xml;
import lombok.Data;

/**
 * com.chenfangming.esb.core
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-15 22:17
 */
@Data
public class EsbRequest<H extends EsbHead, B extends EsbBody> implements Xml<H, B> {

    private H Head;
    private B Body;

}
