package com.chenfangming.manage.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色资源
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:56
 */
@Mapper
@Repository
public interface RoleMenuMapper {

    /**
     * 根据角色id列表,查询资源id列表
     * @param roleIdList 用户id
     * @return 角色列表
     */
    List<Long> selectByRoleIdList(@Param("roleIdList") List<Long> roleIdList);

}
