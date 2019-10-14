package com.chenfangming.esb.test;

import com.chenfangming.esb.core.EsbRequest;
import com.chenfangming.esb.core.EsbRequestHead;
import lombok.Data;

/**
 * Esb3002
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-15 00:32
 */
@Data
public class Esb3002 implements EsbRequest<> {

    private EsbRequestHead Head;
    private Esb3002 Body;

}
