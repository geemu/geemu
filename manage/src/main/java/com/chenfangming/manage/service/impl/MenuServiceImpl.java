package com.chenfangming.manage.service.impl;

import com.chenfangming.manage.persistence.entity.RoleEntity;
import com.chenfangming.manage.persistence.entity.view.MenuRoleView;
import com.chenfangming.manage.persistence.mapper.MenuMapper;
import com.chenfangming.manage.service.MenuService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 资源
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 22:53
 */
@Slf4j
@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {

    private MenuMapper menuMapper;

    /**
     * 查询所有资源及其可以访问的角色集合
     * @return 所有资源其可以访问的角色集合
     */
    @Override
    public List<MenuRoleView> selectAllWithRole() {
        return menuMapper.selectAllWithRole().orElse(Collections.emptyList());
    }

    /**
     * 判断用户是否可以访问资源
     * @param userRoleList 用户所拥有的角色集合
     * @param canAccessRoleList 可以访问当前资源的角色集合
     * @return {@code true}可以访问;{@code false}拒绝访问
     */
    @Override
    public boolean canAccess(List<RoleEntity> userRoleList, List<RoleEntity> canAccessRoleList) {
        if (null == canAccessRoleList) {
            return Boolean.TRUE;
        }
        // 可以访问当前资源的角色集合
        Iterator<RoleEntity> canAccessRole = canAccessRoleList.iterator();
        // 当前认证对象所拥有的角色列表
        Iterator<RoleEntity> userRole = userRoleList.iterator();
        while (canAccessRole.hasNext()) {
            // 可以访问的角色id
            Long canAccessRoleId = canAccessRole.next().getId();
            while (userRole.hasNext()) {
                // 当前用户的角色id
                Long userRoleId = userRole.next().getId();
                if (userRoleId.equals(canAccessRoleId)) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

}
