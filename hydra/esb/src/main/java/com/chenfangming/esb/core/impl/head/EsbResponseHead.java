package com.chenfangming.esb.core.impl.head;

import com.chenfangming.esb.core.impl.Esb;
import com.chenfangming.esb.core.impl.sign.EsbBody;
import lombok.Data;

/**
 * ESB Head
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-17 23:25
 */
@Data
public class EsbResponseHead implements Esb, EsbBody {

    private String ServiceCode;

}
