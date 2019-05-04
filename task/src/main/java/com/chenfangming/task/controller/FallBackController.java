package com.chenfangming.task.controller;


import com.chenfangming.task.config.AppAutoConfiguration.AppProperties;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class FallBackController {

    /** appProperties **/
    private AppProperties appProperties;

    /**
     * 回调返回 Authorization Code
     * @param code Authorization Code
     * @param state 用于防范CSRF攻击的验证参数
     * @return 获取到的用户信息
     */
    @GetMapping("qq")
    public Object qq(String code, String state) {
        log.info("QQ回调");
        return null;
    }
}
