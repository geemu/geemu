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

    /**
     * 获取数据库类型
     * @param type 数据库类型字符串
     */
    public static DbType getDbType(String type) {
        if (null == type || "".equals(type)) {
            log.error("数据库类型不能为空");
            return UNKNOW;
        }
        DbType[] typeArray = DbType.values();
        for (DbType item : typeArray) {
            if (type.equals(item.name())) {
                return item;
            }
        }
        log.info("未知的数据库类型:{}", type);
        return UNKNOW;
    }

}
