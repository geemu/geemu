//package com.chenfangming.manage.config.security;
//
//
//import com.chenfangming.common.domain.DefaultResponseStatus;
//import org.springframework.security.access.AccessDecisionManager;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.authentication.InsufficientAuthenticationException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.Iterator;
//
///**
// * 判断用户是否有权限
// * @author 陈方明  cfmmail@sina.com
// * @since 2018-12-01 18:55
// */
//@Component
//public class AccessDecide implements AccessDecisionManager {
//    /**
//     * 判断用户是否有权限访问资源
//     * @param auth 认证对象
//     * @param obj 被保护的对象
//     * @param coll 当前资源所能访问的角色列表
//     * @throws AccessDeniedException AccessDeniedException
//     * @throws InsufficientAuthenticationException InsufficientAuthenticationException
//     */
//    @Override
//    public void decide(Authentication auth, Object obj, Collection<ConfigAttribute> coll) throws AccessDeniedException, InsufficientAuthenticationException {
//        if (auth instanceof AnonymousAuthenticationToken) {
//            throw new InsufficientAuthenticationException(DefaultResponseStatus.NO_AUTHENTICATION.getMessage());
//        }
//        //  当前资源所有访问的角色列表
//        Iterator<ConfigAttribute> canAccessRoleSet = coll.iterator();
//        //  当前认证对象所拥有的角色列表
//        Collection<? extends GrantedAuthority> currentRoleSet = auth.getAuthorities();
//        while (canAccessRoleSet.hasNext()) {
//            //  可以访问的角色
//            String canAccess = canAccessRoleSet.next().getAttribute();
//            for (GrantedAuthority authority : currentRoleSet) {
//                if (authority.getAuthority().equals(canAccess)) {
//                    return;
//                }
//            }
//        }
//        throw new AccessDeniedException(DefaultResponseStatus.NO_AUTHORIZE.getMessage());
//    }
//
//    @Override
//    public boolean supports(ConfigAttribute configAttribute) {
//        return Boolean.TRUE;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Boolean.TRUE;
//    }
//}
