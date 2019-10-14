package com.chenfangming.esb.core;

import com.chenfangming.core.Xml;
import com.chenfangming.core.XmlBody;

import java.util.ArrayList;
import java.util.List;

/**
 * EsbRequest
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-15 00:34
 */
public interface EsbRequest<Body> extends Xml<EsbRequestHead, XmlBody> {

//    private EsbRequestHead Head;
//    private Body Body;
    List<String> a = new ArrayList<>();

}
