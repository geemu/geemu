package com.chenfangming.manage.service;

import com.chenfangming.manage.persistence.entity.RoleEntity;

import java.util.List;

/**
 * 角色
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:56
 */
public interface RoleService {

    /**
     * 根据用户id查询用户角色集合
     * @param userId 用户id
     * @return 角色集合
     */
    List<RoleEntity> selectByUserId(Long userId);

    /**
     * 查询可访问当前请求资源的角色集合
     * @param requestMethod 请求方法
     * @param requestUri 请求路径
     * @return {@code null}当前资源未进行权限配置,可直接访问;{@code List}能够访问当前资源的角色集合
     */
    List<RoleEntity> selectByRequest(String requestMethod, String requestUri);

}
