package com.chenfangming.manage.persistence.mapper;

import com.chenfangming.manage.persistence.entity.view.MenuRoleView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 一个资源对应多个角色
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:56
 */
@Mapper
@Repository
public interface MenuRoleMapper {

    /**
     * 查询所有资源及其对应的角色
     * @return 所有资源及其对应的角色
     */
    List<MenuRoleView> selectAll();

}
