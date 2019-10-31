package com.chenfangming.manage.service;

import com.chenfangming.manage.domain.req.LoginRequest;

/**
 * 登录
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:55
 */
public interface LoginService {

    /**
     * 用户名、密码登录
     * @param condition 用户名、密码
     * @return token
     */
    String login(LoginRequest condition);

    /**
     * QQ登录
     * @return String
     */
    String qq();

}
