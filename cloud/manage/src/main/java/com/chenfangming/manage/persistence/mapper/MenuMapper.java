package com.chenfangming.manage.persistence.mapper;

import com.chenfangming.manage.persistence.entity.MenuEntity;
import com.chenfangming.manage.persistence.entity.view.MenuRoleView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 资源
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:56
 */
@Mapper
@Repository
public interface MenuMapper {

    /**
     * 根据资源id列表,查询资源列表
     * @param menuIdList 资源id列表
     * @return 资源列表
     */
    List<MenuEntity> selectByMenuIdList(@Param("menuIdList") List<Long> menuIdList);

    /**
     * 根据角色id,查询目录、菜单、按钮
     * @param roleIdList 角色id列表
     * @return 目录、菜单集合
     */
    List<MenuEntity> selectByRoleIdList(@Param("roleIdList") List<Long> roleIdList);

    /**
     * 查询所有资源及其可以访问的角色集合
     * @return 所有资源其可以访问的角色集合
     */
    List<MenuRoleView> selectAllWithRole();

}
