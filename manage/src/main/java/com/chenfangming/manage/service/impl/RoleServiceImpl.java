package com.chenfangming.manage.service.impl;

import com.chenfangming.manage.persistence.entity.RoleEntity;
import com.chenfangming.manage.persistence.entity.view.MenuRoleView;
import com.chenfangming.manage.persistence.mapper.MenuMapper;
import com.chenfangming.manage.persistence.mapper.RoleMapper;
import com.chenfangming.manage.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 角色
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 22:52
 */
@Slf4j
@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    /** 匹配URL **/
    private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();
    private RoleMapper roleMapper;
    private MenuMapper menuMapper;

    /**
     * 根据用户id查询用户角色列表
     * @param userId 用户id
     * @return 角色列表
     */
    @Override
    public List<RoleEntity> selectByUserId(Long userId) {
        return roleMapper.selectByUserId(userId);
    }

    /**
     * 查询可访问当前请求资源的角色集合
     * @param requestMethod 请求方法
     * @param requestUri 请求路径
     * @return {@code null}当前资源未进行权限配置,可直接访问;{@code List}能够访问当前资源的角色集合
     */
    @Override
    public List<RoleEntity> selectByRequest(String requestMethod, String requestUri) {
        // 所有资源及其可以访问的角色集合
        List<MenuRoleView> buttonWithRole = menuMapper.selectAllWithRole();
        Iterator<MenuRoleView> iterator = buttonWithRole.iterator();
        String requestPath = requestMethod + ":" + requestUri;
        while (iterator.hasNext()) {
            MenuRoleView menuRoleView = iterator.next();
            List<RoleEntity> roleEntityList = menuRoleView.getRoleEntityList();
            if (CollectionUtils.isEmpty(roleEntityList)) {
                log.info("资源:{}不存在可以访问的角色", menuRoleView);
                return Collections.emptyList();
            }
            String configMethod = null == menuRoleView.getMethod() ? "" : menuRoleView.getMethod();
            String configPattern = null == menuRoleView.getPattern() ? "" : menuRoleView.getPattern();
            String pattern = configMethod + ":" + configPattern;
            boolean match = ANT_PATH_MATCHER.match(pattern, requestPath);
            if (match) {
                return roleEntityList;
            }
        }
        return null;
    }

}
