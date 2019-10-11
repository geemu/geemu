package com.chenfangming.manage.service.auth;

import com.chenfangming.manage.persistence.entity.RoleEntity;
import com.chenfangming.manage.persistence.entity.view.MenuRoleView;

import java.util.List;

/**
 * 资源
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:56
 */
public interface MenuService {

    /**
     * 查询所有资源及其可以访问的角色集合
     * @return 所有资源其可以访问的角色集合
     */
    List<MenuRoleView> selectAllWithRole();

    /**
     * 判断用户是否可以访问资源
     * @param userRoleList 用户所拥有的角色集合 {@link RoleService#selectByUserId(Long)}
     * @param canAccessRoleList 可以访问当前资源的角色集合 {@link RoleService#selectByRequest(String, String)}
     * @return {@code true}可以访问;{@code false}拒绝访问
     */
    boolean canAccess(List<RoleEntity> userRoleList, List<RoleEntity> canAccessRoleList);

}
