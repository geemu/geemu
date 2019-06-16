package com.chenfangming.manage.persistence.mapper;

import com.chenfangming.manage.persistence.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * 资源数据表操作
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:56
 */
@Mapper
@Repository
public interface MenuMapper {

    /**
     * 查询所有资源
     * 未删除、启用的资源
     * @return 所有资源
     */
    List<MenuEntity> selectAll();


    /**
     * 查询用户菜单
     * @param ids 角色id集合
     * @return 菜单集合
     */
    List<MenuEntity> selectUserMenu(@Param("ids") Set<Long> ids);

}
