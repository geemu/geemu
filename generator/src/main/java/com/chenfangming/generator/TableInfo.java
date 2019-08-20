package com.chenfangming.generator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数据表
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-08-18 19:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TableInfo {

    /** 表名 **/
    private String name;
    /** 表注释 **/
    private String comment;
    /** 数据表字段 **/
    private List<TableField> tableFieldList;
    /** 实体名 **/
    private String entityName;
    /** 接口Mapper名 **/
    private String mapperName;
    /** xml名 **/
    private String xmlName;
    /** 导入包 **/
    private Set<String> pkgSet = new HashSet<>();

}
