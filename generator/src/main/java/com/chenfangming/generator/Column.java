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
public class Column {

    /** 字段名 **/
    private String name;
    /** 类型 **/
    private String type;
    /** 字段注释 **/
    private String comment;

    @Override
    public String toString() {
        return "Column{" +
            "name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", comment='" + comment + '\'' +
            '}';
    }
}
