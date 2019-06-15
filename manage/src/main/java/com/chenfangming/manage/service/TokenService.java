package com.chenfangming.manage.service;

import java.util.Map;

/**
 * Token工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-15 20:24
 */
public interface TokenService {

    /**
     * 创建一个Token
     * @param map 存储的数据
     * @param expired 过期时间
     * @return Token
     */
    String createToken(Map<String, Object> map, long expired);

    /**
     * 创建一个RefreshToken
     * @param token token
     * @return RefreshToken
     */
    String createRefreshToken(String token);

    /**
     * 刷新Token
     * @param refreshToken RefreshToken
     * @return Token
     */
    String refresh(String refreshToken);

    /**
     * 销毁Token、RefreshToken
     */
    void destroy(String token);
}
