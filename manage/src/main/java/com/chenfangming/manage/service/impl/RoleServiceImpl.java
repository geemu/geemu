package com.chenfangming.manage.service.impl;

import com.chenfangming.manage.persistence.entity.RoleEntity;
import com.chenfangming.manage.persistence.entity.view.MenuRoleView;
import com.chenfangming.manage.persistence.mapper.RoleMapper;
import com.chenfangming.manage.service.auth.MenuService;
import com.chenfangming.manage.service.auth.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 22:52
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    /** 匹配URL **/
    private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuService menuService;

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
     * @param method 请求方法
     * @param path 请求路径
     * @return 能够访问当前资源的角色集合
     */
    @Override
    public List<RoleEntity> selectByRequest(String method, String path) {
        // 所有资源及其可以访问的角色集合
        List<MenuRoleView> menuWithRoleList = menuService.selectAllWithRole();
        Iterator<MenuRoleView> iterator = menuWithRoleList.iterator();
        String restfulPath = method.concat(":").concat(path);
        while (iterator.hasNext()) {
            MenuRoleView menuRoleView = iterator.next();
            List<RoleEntity> roleEntityList = menuRoleView.getRoleEntityList();
            if (CollectionUtils.isEmpty(roleEntityList)) {
                log.warn("资源:{},不存在可以访问的角色", restfulPath);
                return Collections.emptyList();
            }
            String configMethod = null == menuRoleView.getMethod() ? "" : menuRoleView.getMethod();
            String configPattern = null == menuRoleView.getPattern() ? "" : menuRoleView.getPattern();
            String restfulPattern = configMethod.concat(":").concat(configPattern);
            boolean matched = ANT_PATH_MATCHER.match(restfulPattern, restfulPath);
            if (matched) {
                return roleEntityList;
            }
        }
        // 资源未配置,那么所有角色都可以访问
        log.info("资源:{}未配置,所有角色都可以访问", restfulPath);
        return menuWithRoleList.stream().flatMap(e -> e.getRoleEntityList().stream()).collect(Collectors.toList());
    }

}
