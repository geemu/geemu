package com.chenfangming.task.controller;


import com.chenfangming.task.config.AppAutoConfiguration.AppProperties;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 第三方回调控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-05-04 18:23
 */
@Slf4j
@RestController
@AllArgsConstructor
@Api("第三方回调控制器")
@RequestMapping("fallback")
public class CallBackController {

    /** appProperties **/
    private AppProperties appProperties;
    /** RestTemplate **/
    private RestTemplate restTemplate;


    /**
     * 回调返回 Authorization Code
     * @param code Authorization Code
     * @param state 用于防范CSRF攻击的验证参数
     * @return 获取到的用户信息
     */
    @SuppressWarnings("unchecked")
    @GetMapping("qq")
    public Object qq(String code, String state) {
        log.info("QQ回调：[code{}],[state:{}]", code, state);
        String url = appProperties.getQq().getOauthServerUrl() + "oauth2.0/token" +
                "?grant_type=authorization_code"
                + "&client_id=" + appProperties.getQq().getAppId()
                + "&client_secret=" + appProperties.getQq().getAppKey()
                + "&code=" + code
                + "&redirect_uri=" + appProperties.getQq().getCallBackUrl();
        String response = restTemplate.getForObject(url, String.class);
        if (null == response) {
            log.error("获取accessToken结果为null");
            return null;
        }
        log.info("获取accessToken结果为:{}", response);
        // 获取返回数据
        String[] kv = response.split("&");
        Map<String, String> map = new HashMap<>(kv.length);
        for (String item : kv) {
            String[] temp = item.split("=");
            map.put(temp[0], temp[1]);
        }
        String urlOpenId = appProperties.getQq().getOauthServerUrl() + "oauth2.0/me" +
                "?access_token=" + map.get("access_token");
        String responseOpenId = restTemplate.getForObject(urlOpenId, String.class);
        if (null == responseOpenId) {
            log.error("获取OpenId结果为null");
            return null;
        }
        log.info("获取OpenId结果为:{}", responseOpenId);
        String openId = responseOpenId.replace("callback(", "")
                .replace(")", "")
                .replace(" ", "");
        log.info("openId返回结果为：{}", openId);
        Map<String, String> openIdMap;
        try {
            openIdMap = new ObjectMapper().readValue(openId, Map.class);
        } catch (IOException e) {
            log.error("openId结果转JSON异常:{}{}", e, "");
            return null;
        }
        // 获取用户信息
        String userInfoUrl = appProperties.getQq().getOauthServerUrl() + "user/get_user_info" +
                "?access_token=" + map.get("access_token")
                + "&oauth_consumer_key=" + appProperties.getQq().getAppId()
                + "&openid=" + openIdMap.get("openid");
        String userInfoResponse = restTemplate.getForObject(userInfoUrl, String.class);
        if (null == userInfoResponse) {
            log.error("获取用户信息结果为null");
            return null;
        }
        log.info("用户信息为:{}", userInfoResponse);
        return userInfoResponse;
    }
}
