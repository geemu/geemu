package com.chenfangming.manage.persistence.mapper;

import com.chenfangming.manage.persistence.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:55
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 根据用户名,查询系统用户
     * @param username 用户名
     * @return UserEntity
     */
    UserEntity selectByUserName(String username);

}
