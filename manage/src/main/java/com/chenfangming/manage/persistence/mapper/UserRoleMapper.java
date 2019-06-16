package com.chenfangming.manage.persistence.mapper;

import com.chenfangming.manage.persistence.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 一个用户对应多个角色
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:56
 */
@Mapper
@Repository
public interface UserRoleMapper {

    /**
     * 根据用户id查询角色列表
     * @param userId 用户id
     * @return 用户对应的角色列表
     */
    List<RoleEntity> selectByUserId(@Param("userId") Long userId);

}
