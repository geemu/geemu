package com.chenfangming.manage.service.impl;

import com.chenfangming.manage.config.exception.BaseResponse.BaseResponseState;
import com.chenfangming.manage.config.exception.BizException;
import com.chenfangming.manage.domain.model.CurrentUserInfo;
import com.chenfangming.manage.persistence.entity.RoleEntity;
import com.chenfangming.manage.persistence.entity.UserEntity;
import com.chenfangming.manage.persistence.entity.view.MenuRoleView;
import com.chenfangming.manage.persistence.mapper.MenuMapper;
import com.chenfangming.manage.persistence.mapper.RoleMapper;
import com.chenfangming.manage.persistence.mapper.UserMapper;
import com.chenfangming.manage.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 认证、授权
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-11-01 21:22
 */
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    /** 匹配URL **/
    private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户
     */
    @Override
    public CurrentUserInfo loadUserByUsername(String username) {
        log.info("用户:{},执行登录", username);
        // 用户
        UserEntity userEntity = userMapper.selectByUserName(username);
        if (null == userEntity) {
            throw new BizException(BaseResponseState.USER_NOT_EXISTED);
        }
        // 角色列表
        List<RoleEntity> roleEntityList = roleMapper.selectByUserId(userEntity.getUserId());
        return CurrentUserInfo.builder()
                .userId(userEntity.getUserId())
                .username(userEntity.getUsername())
                .roleIdCollection(roleEntityList.stream().map(RoleEntity::getRoleId).collect(Collectors.toList()))
                .build();
    }

    /**
     * 查询所有资源及其对应的角色集合
     * @return 所有资源及其对应的角色集合
     */
    @Override
    public Collection<MenuRoleView> getAllConfigAttributes() {
        return menuMapper.selectAllWithRole();
    }

    /**
     * 查询当前请求资源对应的的角色集合
     * @param httpMethod httpMethod
     * @param requestUri requestUri
     * @return 当前请求资源对应的的角色id集合
     */
    @Override
    public Collection<Long> getAttributes(String httpMethod, String requestUri) {
        // 所有资源及其可以访问的角色集合
        Collection<MenuRoleView> menuRoleViewCollection = getAllConfigAttributes();
        Iterator<MenuRoleView> iterator = menuRoleViewCollection.iterator();
        String path = httpMethod.concat(":").concat(requestUri);
        while (iterator.hasNext()) {
            MenuRoleView menuRoleView = iterator.next();
            List<RoleEntity> roleEntityList = menuRoleView.getRoleEntityList();
            String configMethod = null == menuRoleView.getMethod() ? "" : menuRoleView.getMethod() + "";
            String configPattern = null == menuRoleView.getPattern() ? "" : menuRoleView.getPattern();
            String pattern = configMethod.concat(":").concat(configPattern);
            boolean matched = ANT_PATH_MATCHER.match(pattern, path);
            if (matched) {
                return roleEntityList.stream().map(RoleEntity::getRoleId).collect(Collectors.toList());
            }
        }
        // 资源未配置,那么所有角色都可以访问
        log.info("资源:{}未配置,所有角色都可以访问", path);
        return menuRoleViewCollection.stream()
                .flatMap(e -> e.getRoleEntityList().stream().map(RoleEntity::getRoleId))
                .collect(Collectors.toList());
    }

    /**
     * 判断用户是否可以访问资源
     * @param userRoleIdCol 用户所拥有的角色id集合
     * @param canAccessRoleIdCol 可以访问当前资源的角色id集合
     * @return {@code true}可以访问、{@code false}拒绝访问
     */
    @Override
    public boolean decide(Collection<Long> userRoleIdCol, Collection<Long> canAccessRoleIdCol) {
        userRoleIdCol.retainAll(canAccessRoleIdCol);
        return userRoleIdCol.size() > 0;
    }

}
