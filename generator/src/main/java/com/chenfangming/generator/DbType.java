package com.chenfangming.generator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 数据库类型
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-08-18 20:05
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum DbType {

    /** MYSQL **/
    MYSQL,
    /** 未知的数据库类型 **/
    UNKNOW;

}
