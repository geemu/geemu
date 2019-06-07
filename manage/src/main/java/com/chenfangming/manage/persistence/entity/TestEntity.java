package com.chenfangming.manage.persistence.entity;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 测试数据表实体
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-21 12:45
 */
@Data
@Valid
public class TestEntity implements Serializable {

    /** 主键 **/
    @NotNull(message = "主键不能为空")
    @NotEmpty
    private Long id;
    /** 姓名 **/
    @NotEmpty(message = "姓名不能为空")
    private String name;
    /** 未删除 true:未删除 false:已删除 **/
    @AssertTrue(message = "只能为true")
    private Boolean nonDeleted;
    /** 创建时间 **/
    private Date createTime;

}
