package com.chenfangming.manage.controller;

import com.chenfangming.common.domain.ResponseEntity;
import com.chenfangming.manage.persistence.entity.RoleEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 角色控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-13 22:29
 */
@Slf4j
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("role")
@Api(tags = "角色控制器")
public class RoleController {

    @ApiOperation("新增一个角色")
    @PostMapping
    public ResponseEntity<RoleEntity> add(@Valid RoleEntity roleEntity) {
        return null;
    }

    @ApiOperation("根据主键删除角色")
    @DeleteMapping
    public ResponseEntity<Void> del(@Valid Long id) {
        return null;
    }

    @ApiOperation("根据主键修改角色信息")
    @PutMapping
    public ResponseEntity<RoleEntity> edit(@Valid RoleEntity roleEntity) {
        return null;
    }

    @ApiOperation("根据条件查询角色信息")
    @PutMapping
    public ResponseEntity<RoleEntity> find(@Valid RoleEntity roleEntity) {
        return null;
    }

}
