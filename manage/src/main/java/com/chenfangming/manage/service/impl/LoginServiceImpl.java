package com.chenfangming.manage.service.impl;

import com.chenfangming.manage.config.auto.property.AppProperty;
import com.chenfangming.manage.config.exception.BizException;
import com.chenfangming.manage.config.exception.DefaultResponseState;
import com.chenfangming.manage.domain.req.NamePwdReq;
import com.chenfangming.manage.persistence.entity.UserEntity;
import com.chenfangming.manage.persistence.mapper.UserMapper;
import com.chenfangming.manage.service.LoginService;
import com.chenfangming.manage.util.UrlUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * com.chenfangming.manage.service.impl
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:29
 */
@Slf4j
@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    /** 应用配置参数 **/
    private AppProperty appProperties;
    private UserMapper userMapper;

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
    public UserEntity login(NamePwdReq condition) {
        UserEntity userEntity = userMapper.selectByName(condition.getName())
            .orElseThrow(() -> new BizException(DefaultResponseState.FAIL, "用户名或密码错误"));
        if (!userEntity.getEnabled()) {
            throw new BizException(DefaultResponseState.FAIL, "用户被禁用");
        }
        if (!userEntity.getPassword().equals(condition.getPassword())) {
            throw new BizException(DefaultResponseState.FAIL, "用户名或密码错误");
        }
        return userEntity;
    }

}
