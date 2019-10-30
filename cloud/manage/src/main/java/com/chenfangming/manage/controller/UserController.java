package com.chenfangming.manage.controller;


import com.chenfangming.manage.config.exception.BaseResponse;
import com.chenfangming.manage.domain.req.LoginRequest;
import com.chenfangming.manage.persistence.entity.UserEntity;
import com.chenfangming.manage.service.LoginService;
import com.chenfangming.manage.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-13 22:29
 */
@Slf4j
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("user")
@Api(tags = "用户控制器")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @ApiOperation("用户名密码登录")
    @PostMapping("login")
    public String login(@RequestBody @Valid LoginRequest condition) {
        return userService.login(condition);
    }

    @ApiOperation("QQ登录")
    @GetMapping("qq")
    public String qq() {
        log.info("QQ登录");
        String url = loginService.qq();
        log.info("当前QQ登录地址为:{}", url);
        return url;
    }


    @ApiOperation("新增一个用户")
    @PostMapping
    public BaseResponse<UserEntity> add(@Valid UserEntity userEntity) {
        return null;
    }

    @ApiOperation("根据主键删除用户")
    @DeleteMapping
    public BaseResponse<Void> del(@Valid Long id) {
        return null;
    }

    @ApiOperation("根据主键修改用户信息")
    @PutMapping
    public BaseResponse<UserEntity> edit(@Valid UserEntity userEntity) {
        return null;
    }

    @ApiOperation("根据条件查询用户信息")
    @GetMapping
    public BaseResponse<UserEntity> find(@Valid UserEntity userEntity) {
        return null;
    }

}
