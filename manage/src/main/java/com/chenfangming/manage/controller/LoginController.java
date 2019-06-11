package com.chenfangming.manage.controller;

import com.chenfangming.manage.config.auto.property.AppProperty;
import com.chenfangming.manage.util.UrlUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-05-04 20:13
 */
@Slf4j
@RestController
@AllArgsConstructor
@Api(tags = "登录控制器")
@RequestMapping("login")
public class LoginController {

    /** appProperties **/
    private AppProperty appProperties;

    @ApiOperation("QQ登录")
    @GetMapping("qq")
    public String qq() {
        log.info("QQ登录");
        String encodedCallBackUrl = UrlUtils.encode(appProperties.getQq().getCallBackUrl());
        return appProperties.getQq().getOauthServerUrl() + "oauth2.0/authorize"
                + "?response_type=code"
                + "&client_id=" + appProperties.getQq().getAppId()
                + "&redirect_uri=" + encodedCallBackUrl
                + "&state=" + "123456789"
                + "&scope=get_user_info"
                + "&display=pc";
    }

}
