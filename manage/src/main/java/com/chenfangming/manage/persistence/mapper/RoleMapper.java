package com.chenfangming.manage.persistence.mapper;

import com.chenfangming.manage.persistence.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 角色
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:56
 */
@Mapper
@Repository
public interface RoleMapper {

    /**
     * 根据用户id查询角色
     * @param userId 用户id
     * @return 角色集合
     */
    Optional<List<RoleEntity>> selectByUserId(@Param("userId") Long userId);

}
