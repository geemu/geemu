package com.chenfangming.manage.controller;


import com.chenfangming.manage.config.exception.BaseResponse;
import com.chenfangming.manage.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-05-04 20:13
 */
@Slf4j
@Validated
@RestController
@Api(tags = "登录控制器")
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation("QQ登录")
    @GetMapping("qq")
    public BaseResponse<String> qq() {
        log.info("QQ登录");
        String url = loginService.qq();
        log.info("当前QQ登录地址为:{}", url);
        return new BaseResponse<>(url);
    }


}
