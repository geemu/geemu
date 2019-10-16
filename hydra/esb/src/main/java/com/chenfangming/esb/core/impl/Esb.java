package com.chenfangming.esb.core.impl;

import com.chenfangming.esb.core.sign.EsbBodyStyle;
import com.chenfangming.esb.core.sign.EsbHeadStyle;
import lombok.Data;

/**
 * com.chenfangming.esb.core
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-15 22:17
 */
@Data
public class Esb<H extends EsbHeadStyle, B extends EsbBodyStyle> extends AbstractEsb<H, B> {

    private H Head;
    private B Body;

}
