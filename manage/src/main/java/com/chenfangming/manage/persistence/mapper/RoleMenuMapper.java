package com.chenfangming.manage.persistence.mapper;

import com.chenfangming.manage.persistence.entity.view.MenuRoleView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 一个角色对应多个资源
 * 一个资源对应多个角色
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 21:52
 */
@Mapper
@Repository
public interface RoleMenuMapper {

    /**
     * 查询所有资源和角色的对应关系
     * @return 资源对应角色的集合
     */
    List<MenuRoleView> selectAllMenuRole();

}
