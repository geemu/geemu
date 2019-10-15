package com.chenfangming.esb.core.impl;

import com.chenfangming.esb.core.sign.EsbBodyType;
import com.chenfangming.esb.core.sign.EsbHeadType;
import lombok.Data;

/**
 * com.chenfangming.esb.core
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-15 22:17
 */
@Data
public class Esb<H extends EsbHeadType, B extends EsbBodyType> extends AbstractEsb<H, B> {

    private H Head;
    private B Body;

}
