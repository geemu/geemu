package com.chenfangming.manage.service;

import com.chenfangming.manage.domain.model.CurrentUserInfo;
import com.chenfangming.manage.persistence.entity.view.MenuRoleView;

import java.util.Collection;

/**
 * 认证、授权
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-11-01 21:22
 */
public interface AuthService {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户
     */
    CurrentUserInfo loadUserByUsername(String username);

    /**
     * 查询所有资源及其对应的角色集合
     * @return 所有资源及其对应的角色集合
     */
    Collection<MenuRoleView> getAllConfigAttributes();

    /**
     * 查询当前请求资源对应的的角色集合
     * @param httpMethod httpMethod
     * @param requestUri requestUri
     * @return 当前请求资源对应的的角色id集合
     */
    Collection<Long> getAttributes(String httpMethod, String requestUri);

    /**
     * 判断用户是否可以访问资源
     * @param userRoleIdCol 用户所拥有的角色id集合
     * @param canAccessRoleIdCol 可以访问当前资源的角色id集合
     * @return {@code true}可以访问、{@code false}拒绝访问
     */
    boolean decide(Collection<Long> userRoleIdCol, Collection<Long> canAccessRoleIdCol);

}
