package com.chenfangming.task.controller;

import com.chenfangming.task.config.AppAutoConfiguration.AppProperties;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 登录控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-05-04 20:13
 */
@Slf4j
@RestController
@AllArgsConstructor
@Api("登录控制器")
@RequestMapping("login")
public class LoginController {

    /** appProperties **/
    private AppProperties appProperties;

    @GetMapping("qq")
    public String qq() {
        log.info("QQ登录");
        String encodedFallBackUrl;
        try {
            encodedFallBackUrl = URLEncoder.encode(appProperties.getQq().getFallBackUrl(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("URL编码异常:{}{}", e, "");
            return null;
        }
        return appProperties.getQq().getOauthServerUrl()
                + "authorize?response_type=code&client_id=" + appProperties.getQq().getAppId()
                + "&redirect_uri=" + encodedFallBackUrl
                + "&state=" + "123456789&scope=get_user_info&display=pc";
    }

}
