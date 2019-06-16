package com.chenfangming.manage.service;

import com.chenfangming.manage.persistence.entity.MenuEntity;

import java.util.List;

/**
 * com.chenfangming.manage.service
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 19:34
 */
public interface MenuServicce {
    /**
     * 查询所有资源
     * @return 所有正常的资源
     */
    List<MenuEntity> select();
}
