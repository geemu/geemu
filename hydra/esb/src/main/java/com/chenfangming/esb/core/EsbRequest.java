package com.chenfangming.esb.core;

import lombok.Builder;
import lombok.Data;

/**
 * ESB 默认请求
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-18 21:10
 */
@Data
@Builder
public class EsbRequest<Body extends EsbBodyStyle> implements Esb<EsbDefaultRequestHead, Body> {

    /** Head **/
    private EsbDefaultRequestHead Head;
    /** Body **/
    private Body Body;

}
