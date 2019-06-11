package com.chenfangming.manage.controller;

import com.chenfangming.manage.config.auto.property.AppProperty;
import com.chenfangming.manage.domain.model.ResponseEntity;
import com.chenfangming.manage.domain.req.NamePasswordLoginReq;
import com.chenfangming.manage.util.UrlUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 登录控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-05-04 20:13
 */
@Slf4j
@Validated
@RestController
@AllArgsConstructor
@Api(tags = "登录控制器")
@RequestMapping("login")
public class LoginController {

    /** 应用配置参数 **/
    private AppProperty appProperties;

    /**
     *
     **/

    @ApiOperation("QQ登录")
    @GetMapping("qq")
    public ResponseEntity<String> qq() {
        log.info("QQ登录");
        String callBackUrl = appProperties.getQq().getCallBackUrl();
        log.info("当前回调地址为:{}", callBackUrl);
        String encodedCallBackUrl = UrlUtils.encode(callBackUrl);
        log.info("URL编码后为:{}", encodedCallBackUrl);
        String url = appProperties.getQq().getOauthServerUrl() + "oauth2.0/authorize"
                + "?response_type=code"
                + "&client_id=" + appProperties.getQq().getAppId()
                + "&redirect_uri=" + encodedCallBackUrl
                + "&state=" + "123456789"
                + "&scope=get_user_info"
                + "&display=pc";
        log.info("请求QQ登录的URL为:{}", url);
        return new ResponseEntity<>(url);
    }

    @ApiOperation("用户名密码登录")
    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid NamePasswordLoginReq condition) {
        return null;
    }


}
