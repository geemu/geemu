package com.chenfangming.manage.persistence.mapper;

import com.chenfangming.manage.persistence.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 资源
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-12 22:56
 */
@Mapper
@Repository
public interface MenuMapper {

    /**
     * 查询所有资源
     * @return 所有资源
     */
    List<MenuEntity> selectAll();

}
