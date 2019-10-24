package com.chenfangming.manage.service;

import com.chenfangming.manage.domain.req.NamePwdReq;
import com.chenfangming.manage.persistence.entity.UserEntity;

/**
 * com.chenfangming.manage.service
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:29
 */
public interface LoginService {

    String qq();

    /**
     * 根据用户名查询用户
     * @param condition 查询条件
     * @return 用户实体
     */
    UserEntity login(NamePwdReq condition);

}
