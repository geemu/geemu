package com.chenfangming.generator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 数据表的列即每一个字段
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-08-18 19:48
 */
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TableField {

    /** 是否是主键字段 {@code true}是主键字段 {@code false}非主键字段 **/
    private Boolean key;
    /** 数据库字段名 **/
    private String jdbcName;
    /** 数据库字段类型 **/
    private String jdbcType;
    /** 字段注释 **/
    private String comment;
    /** 实体字段名 **/
    private String javaName;
    /** 实体字段类型 **/
    private JavaType javaType;

}
