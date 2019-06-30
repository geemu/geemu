package com.chenfangming.manage.controller;

import com.chenfangming.common.model.ResponseEntity;
import com.chenfangming.manage.persistence.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @ApiOperation("新增一个用户")
    @PostMapping
    public ResponseEntity<UserEntity> add(@Valid UserEntity userEntity) {
        return null;
    }

    @ApiOperation("根据主键删除用户")
    @DeleteMapping
    public ResponseEntity<Void> del(@Valid Long id) {
        return null;
    }

    @ApiOperation("根据主键修改用户信息")
    @PutMapping
    public ResponseEntity<UserEntity> edit(@Valid UserEntity userEntity) {
        return null;
    }

    @ApiOperation("根据条件查询用户信息")
    @GetMapping
    public ResponseEntity<UserEntity> find(@Valid UserEntity userEntity) {
        return null;
    }

}
