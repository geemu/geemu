package com.chenfangming.manage.controller;

import com.chenfangming.common.model.ResponseEntity;
import com.chenfangming.manage.persistence.entity.MenuEntity;
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
 * 资源控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-13 22:29
 */
@Slf4j
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("menu")
@Api(tags = "资源控制器")
public class MenuController {

    @ApiOperation("新增一个资源")
    @PostMapping
    public ResponseEntity<MenuEntity> add(@Valid MenuEntity menuEntity) {
        return null;
    }

    @ApiOperation("根据主键删除资源")
    @DeleteMapping
    public ResponseEntity<Void> del(@Valid Long id) {
        return null;
    }

    @ApiOperation("根据主键修改资源信息")
    @PutMapping
    public ResponseEntity<MenuEntity> edit(@Valid MenuEntity menuEntity) {
        return null;
    }

    @ApiOperation("根据条件查询资源信息")
    @GetMapping
    public ResponseEntity<MenuEntity> find(@Valid MenuEntity menuEntity) {
        return null;
    }

}
