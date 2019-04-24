package com.chenfangming.task.mapper;

import com.chenfangming.task.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 测试数据表Dao层
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-21 12:46
 */
@Mapper
public interface TestMapper {

    /**
     * 查询所有
     * @return List
     */
    List<TestEntity> selectAll();
}
