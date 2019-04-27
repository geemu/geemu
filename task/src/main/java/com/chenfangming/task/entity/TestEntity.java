package com.chenfangming.task.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试数据表实体
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-21 12:45
 */
@Data
public class TestEntity implements Serializable {

    /** 主键 **/
    private Long id;
    /** 姓名 **/
    private String name;
    /** 未删除 true:未删除 false:已删除 **/
    private Boolean nonDeleted;
    /** 创建时间 **/
    private Date createTime;

}
