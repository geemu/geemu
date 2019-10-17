package com.chenfangming.esb.core.sign;

import com.chenfangming.esb.core.impl.sign.EsbBody;
import com.chenfangming.esb.core.impl.sign.EsbHead;
import lombok.Data;

/**
 * com.chenfangming.esb.core
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-15 22:17
 */
@Data
public class Esb<H extends EsbHead, B extends EsbBody> extends AbstractEsb<H, B> {

    private H Head;
    private B Body;

}
