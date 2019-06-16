package com.chenfangming.manage.service.impl;

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

}
