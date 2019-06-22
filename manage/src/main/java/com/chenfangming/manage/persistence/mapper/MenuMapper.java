package com.chenfangming.manage.persistence.mapper;

import com.chenfangming.manage.persistence.entity.MenuEntity;
import com.chenfangming.manage.persistence.entity.view.MenuRoleView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * 资源
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:56
 */
@Mapper
@Repository
public interface MenuMapper {

    /**
     * 查询所有资源
     * @return 所有资源
     */
    List<MenuEntity> selectAll();

    /**
     * 查询可用按钮及其可以访问的角色列表
     * @return 菜单、按钮集合及其可以访问的角色列表
     */
    List<MenuRoleView> selectButtonWithRole();

    /**
     * 查询角色对应的可用目录、菜单
     * @param roleIds 角色id集合
     * @return 目录、菜单集合
     */
    List<MenuEntity> selectByRoleId(@Param("roleIds") Set<Long> roleIds);

}
