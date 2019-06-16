package com.chenfangming.manage.config.security;

import com.chenfangming.manage.persistence.entity.RoleEntity;
import com.chenfangming.manage.persistence.entity.UserEntity;
import com.chenfangming.manage.persistence.mapper.RoleMapper;
import com.chenfangming.manage.persistence.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * 自定义加载用户数据
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-11-23 14:09
 */
@Component
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private UserMapper userMapper;
    private RoleMapper roleMapper;


    /**
     * 据用户名查找用户
     * @param userName 用户名
     * @return 用户
     * @throws UsernameNotFoundException 用户名不存在
     */
    @Override
    public UserDetails loadUserByUsername(String userName) {
        //  查询用户
        UserEntity userEntity = userMapper.selectByName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("用户名不存在"));
        //  查询用户所拥有的角色  有效的
        List<RoleEntity> roleEntityList = roleMapper.selectByUserId(userEntity.getId());
        List<GrantedAuthority> authorities = new LinkedList<>();
        for (RoleEntity role : roleEntityList) {
            //  这边应该放角色id
            authorities.add(new SimpleGrantedAuthority(role.getId().toString()));
        }
        return new User(userEntity.getName(), userEntity.getPassword(), userEntity.getEnabled(),
                Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, authorities);
    }

}
