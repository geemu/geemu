package com.chenfangming.manage.controller;


import com.chenfangming.manage.domain.req.LoginRequest;
import com.chenfangming.manage.service.AuthService;
import com.chenfangming.manage.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 登录
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-13 22:29
 */
@Slf4j
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("user")
@Api(tags = "登录")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private LoginService loginService;

    @ApiOperation("用户名密码登录")
    @PostMapping("login")
    public String login(@RequestBody @Valid LoginRequest condition) {
        return authService.login(condition);
    }

    @ApiOperation("QQ登录")
    @GetMapping("qq")
    public String qq() {
        log.info("QQ登录");
        String url = loginService.qq();
        log.info("当前QQ登录地址为:{}", url);
        return url;
    }

}
