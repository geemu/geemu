package com.chenfangming.esb;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ESB 默认请求
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-18 21:10
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class EsbRequest<Body extends EsbBodyStyle> extends AbstractEsb<EsbDefaultRequestHead, Body> implements Esb<EsbDefaultRequestHead, Body> {

    /** Head **/
    private EsbDefaultRequestHead Head;
    /** Body **/
    private Body Body;

}
