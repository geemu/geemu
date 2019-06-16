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

    UserEntity login(NamePwdReq condition);
}
