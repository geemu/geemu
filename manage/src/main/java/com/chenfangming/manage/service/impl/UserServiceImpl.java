package com.chenfangming.manage.service.impl;

import com.chenfangming.common.model.BizException;
import com.chenfangming.common.model.DefaultResponseStatus;
import com.chenfangming.manage.persistence.entity.UserEntity;
import com.chenfangming.manage.persistence.mapper.UserMapper;
import com.chenfangming.manage.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 22:51
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    /**
     * 根据用户名查询用户
     * @param name 用户名
     * @return 用户
     */
    @Override
    public UserEntity selectByName(String name) {
        return userMapper.selectByName(name)
                .orElseThrow(() -> new BizException(DefaultResponseStatus.FAIL, "用户名不存在"));
    }

}
