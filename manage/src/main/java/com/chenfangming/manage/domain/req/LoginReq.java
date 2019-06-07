package com.chenfangming.manage.domain.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录请求体
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-07 13:08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq {

    /** 用户名 **/
    private String name;
    /** 密码 **/
    private String password;
    /** 图形验证码 **/
    private String imgCode;
    /** 短信验证码 **/
    private String smsCode;

}
