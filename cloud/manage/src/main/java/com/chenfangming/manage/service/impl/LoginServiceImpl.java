package com.chenfangming.manage.service.impl;

import com.chenfangming.manage.config.auto.property.AppProperty;
import com.chenfangming.manage.config.exception.BaseResponse.BaseResponseState;
import com.chenfangming.manage.config.exception.BizException;
import com.chenfangming.manage.converter.Converter;
import com.chenfangming.manage.domain.model.CurrentUserInfo;
import com.chenfangming.manage.domain.req.LoginRequest;
import com.chenfangming.manage.persistence.entity.UserEntity;
import com.chenfangming.manage.service.LoginService;
import com.chenfangming.manage.service.UserService;
import com.chenfangming.manage.util.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * com.chenfangming.manage.service.impl
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:29
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AppProperty appProperties;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private Converter converter;

    @Override
    public String qq() {
        String callBackUrl = appProperties.getQq().getCallBackUrl();
        log.info("当前回调地址为:{}", callBackUrl);
        String encodedCallBackUrl = UrlUtils.encode(callBackUrl);
        log.info("URL编码后为:{}", encodedCallBackUrl);
        return appProperties.getQq().getOauthServerUrl() + "oauth2.0/authorize"
                + "?response_type=code"
                + "&client_id=" + appProperties.getQq().getAppId()
                + "&redirect_uri=" + encodedCallBackUrl
                + "&state=" + "123456789"
                + "&scope=get_user_info"
                + "&display=pc";
    }

    @Override
    public String login(LoginRequest condition) {
        UserEntity userEntity = userService.findByName(condition.getName());
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
        HashMapper<Object, String, Object> mapper = new Jackson2HashMapper(Boolean.TRUE);
        String key = "loginUser:" + token;
        CurrentUserInfo currentUserInfo = converter.converterUserEntity2CurrentUserInfo(userEntity);
        redisTemplate.opsForHash().putAll(key, mapper.toHash(currentUserInfo));
        redisTemplate.expire(key, 1, TimeUnit.DAYS);
        return token;
    }

}
