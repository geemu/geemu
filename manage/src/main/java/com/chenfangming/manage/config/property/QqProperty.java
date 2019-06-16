package com.chenfangming.manage.config.property;

import lombok.Data;

/**
 * QQ参数配置
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-07 21:11
 */
@Data
public class QqProperty {

    /** appId **/
    private String appId;
    /** appKey **/
    private String appKey;
    /** 回调地址 **/
    private String callBackUrl;
    /** QQ互联认证服务器地址 **/
    private String oauthServerUrl;

}
