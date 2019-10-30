package com.chenfangming.manage.service.impl;

import com.chenfangming.manage.config.exception.BaseResponse.BaseResponseState;
import com.chenfangming.manage.config.exception.BizException;
import com.chenfangming.manage.converter.Converter;
import com.chenfangming.manage.domain.model.CurrentUserInfo;
import com.chenfangming.manage.domain.req.LoginRequest;
import com.chenfangming.manage.persistence.entity.UserEntity;
import com.chenfangming.manage.persistence.mapper.UserMapper;
import com.chenfangming.manage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 22:51
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Converter converter;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 登录
     * 根据用户名、密码,查询系统用户
     * @param condition 查询条件
     * @return token
     */
    @Override
    public String login(LoginRequest condition) {
        UserEntity userEntity = userMapper.selectByUserName(condition.getName());
        if (null == userEntity) {
            throw new BizException(BaseResponseState.USER_NOT_EXISTED);
        }
        if (!userEntity.getPassword().equals(condition.getPassword())) {
            throw new BizException(BaseResponseState.INVALID_PASSWORD);
        }
        if (!userEntity.getEnabled()) {
            throw new BizException(BaseResponseState.USER_LOCKED);
        }
        // 生成Token
        String token = UUID.randomUUID().toString().replace("-", "");
        String key = CurrentUserInfo.LOGIN_USER + token;
        CurrentUserInfo currentUserInfo = converter.converterUserEntity2CurrentUserInfo(userEntity);
        redisTemplate.opsForHash().put(key, CurrentUserInfo.CURRENT_USER, currentUserInfo);
        redisTemplate.expire(key, 1, TimeUnit.DAYS);
        return token;
    }

    /**
     * 根据用户名查询用户
     * @param name 用户名
     * @return 用户
     */
    @Override
    public UserEntity findByName(String name) {
        return userMapper.selectByUserName(name);
    }

}
