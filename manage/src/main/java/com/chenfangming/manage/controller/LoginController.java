package com.chenfangming.manage.controller;

import com.chenfangming.common.model.ResponseEntity;
import com.chenfangming.manage.domain.req.NamePwdReq;
import com.chenfangming.manage.persistence.entity.UserEntity;
import com.chenfangming.manage.service.LoginService;
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

import javax.servlet.http.HttpServletRequest;
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
    private LoginService loginService;

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
    public ResponseEntity<UserEntity> custom(@RequestBody @Valid NamePwdReq condition, HttpServletRequest request) {
        UserEntity userEntity = loginService.login(condition);
        request.getSession().setAttribute("currentUser", userEntity);
        UserEntity data = (UserEntity) request.getSession().getAttribute("currentUser");
        System.out.println(data);
        return null;
    }


}
