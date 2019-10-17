package com.chenfangming.esb.core.impl.head;

import com.chenfangming.esb.core.impl.Esb;
import com.chenfangming.esb.core.impl.sign.EsbHead;
import lombok.Data;

/**
 * ESB Head
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-17 23:24
 */
@Data
public class EsbRequestHead implements Esb, EsbHead {

    private String ServiceCode;

}
