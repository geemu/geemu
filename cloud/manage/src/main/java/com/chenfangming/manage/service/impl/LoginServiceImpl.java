package com.chenfangming.manage.service.impl;

import com.chenfangming.manage.config.auto.property.AppProperty;
import com.chenfangming.manage.config.exception.BaseResponse.BaseResponseState;
import com.chenfangming.manage.config.exception.BizException;
import com.chenfangming.manage.converter.Converter;
import com.chenfangming.manage.domain.model.CurrentUserInfo;
import com.chenfangming.manage.domain.req.LoginRequest;
import com.chenfangming.manage.persistence.entity.MenuEntity;
import com.chenfangming.manage.persistence.entity.RoleEntity;
import com.chenfangming.manage.persistence.entity.UserEntity;
import com.chenfangming.manage.service.LoginService;
import com.chenfangming.manage.service.RoleService;
import com.chenfangming.manage.service.UserService;
import com.chenfangming.manage.util.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 登录
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 22:51
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private Converter converter;
    @Autowired
    private AppProperty appProperties;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 用户名、密码登录
     * @param condition 用户名、密码
     * @return token
     */
    @Override
    public String login(LoginRequest condition) {
        // 用户
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
        // 角色id列表
        List<Long> roleIdList = roleService.findByUserId(userEntity.getUserId())
                .stream()
                .map(RoleEntity::getRoleId)
                .collect(Collectors.toList());
        // 权限列表
        List<MenuEntity> menuEntityList = null;
        // 生成Token
        String token = UUID.randomUUID().toString().replace("-", "");
        String key = CurrentUserInfo.LOGIN_USER + token;
        CurrentUserInfo currentUserInfo = converter.converterUserEntity2CurrentUserInfo(userEntity);
        currentUserInfo.setMenuEntityList(menuEntityList);
        redisTemplate.opsForValue().set(key, currentUserInfo, 1, TimeUnit.DAYS);
        return token;
    }

    /**
     * QQ登录
     * @return String
     */
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

}
