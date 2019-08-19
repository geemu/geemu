package com.chenfangming.generator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 数据表
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-08-18 19:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Table {

    /** 表名 **/
    private String name;
    /** 表注释 **/
    private String comment;
    /** 数据表字段 **/
    private List<Column> columns;
}
