package com.chenfangming.manage.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenfangming.manage.persistence.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * com.chenfangming.manage.persistence.mapper
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:55
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {

    Optional<UserEntity> selectByName(@Param("name") String name);

}
