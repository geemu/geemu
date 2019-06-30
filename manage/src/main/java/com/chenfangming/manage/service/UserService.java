package com.chenfangming.manage.service;

import com.chenfangming.manage.persistence.entity.UserEntity;

/**
 * 用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:55
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     * @param name 用户名
     * @return 用户
     */
    UserEntity selectByName(String name);

}
