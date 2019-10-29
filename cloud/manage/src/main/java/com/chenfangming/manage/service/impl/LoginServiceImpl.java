package com.chenfangming.manage.service.impl;

import com.chenfangming.manage.config.auto.property.AppProperty;
import com.chenfangming.manage.service.LoginService;
import com.chenfangming.manage.service.UserService;
import com.chenfangming.manage.util.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
