package com.chenfangming.manage.persistence.mapper;

import com.chenfangming.manage.persistence.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:55
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 新增用户
     * @param userEntity 待新增的用户
     * @return 新增后的结果
     */
    Integer addOne(@Param("userEntity") UserEntity userEntity);

    /**
     * 根据用户名查询用户
     * @param name 用户名
     * @return 用户
     */
    Optional<UserEntity> findByName(@Param("name") String name);

}
