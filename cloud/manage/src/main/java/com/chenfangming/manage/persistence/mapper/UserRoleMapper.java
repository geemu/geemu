package com.chenfangming.manage.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户角色
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:56
 */
@Mapper
@Repository
public interface UserRoleMapper {

    /**
     * 根据用户id,查询角色id列表
     * @param userId 用户id
     * @return 角色列表
     */
    List<Long> selectByUserId(@Param("userId") Long userId);

}
