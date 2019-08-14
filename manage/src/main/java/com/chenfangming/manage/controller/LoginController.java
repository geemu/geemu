package com.chenfangming.manage.controller;


import com.chenfangming.manage.config.exception.ResponseEntity;
import com.chenfangming.manage.domain.constants.SessionKey;
import com.chenfangming.manage.domain.model.CurrentUserInfo;
import com.chenfangming.manage.domain.req.NamePwdReq;
import com.chenfangming.manage.persistence.entity.RoleEntity;
import com.chenfangming.manage.persistence.entity.UserEntity;
import com.chenfangming.manage.service.LoginService;
import com.chenfangming.manage.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private RoleService roleService;

    @ApiOperation("QQ登录")
    @GetMapping("qq")
    public ResponseEntity<String> qq() {
        log.info("QQ登录");
        String url = loginService.qq();
        log.info("当前QQ登录地址为:{}", url);
        return new ResponseEntity<>(url);
    }

    @ApiOperation("用户名密码登录")
    @PostMapping
    public ResponseEntity<CurrentUserInfo> custom(@RequestBody @Valid NamePwdReq condition) {
        UserEntity userEntity = loginService.login(condition);
        List<RoleEntity> roleEntityList = roleService.selectByUserId(userEntity.getId());
        List<Long> roleIdList = roleEntityList.stream()
            .map(RoleEntity::getId)
            .collect(Collectors.toList());
        CurrentUserInfo currentUserInfo = CurrentUserInfo.builder()
            .id(userEntity.getId())
            .name(userEntity.getName())
            .roleIdList(roleEntityList)
            .build();
        RequestContextHolder.currentRequestAttributes().setAttribute(SessionKey.CURRENT_USER.name(), currentUserInfo, RequestAttributes.SCOPE_SESSION);
        return new ResponseEntity<>(currentUserInfo);
    }

}
