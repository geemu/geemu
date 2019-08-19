package com.chenfangming.generator;

/**
 * 表数据查询接口
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-08-19 20:48
 */
public interface IDbQuery {

    /**
     * 数据库类型
     */
    DbType getDbType();

    /**
     * 获取所有数据表名
     * @return SQL
     */
    String getTableNames();

    /**
     * 获取数据表注释
     * @param tableName 数据表名
     * @return SQL
     */
    String getTableComment(String tableName);

    /**
     * 获取数据表所有字段名
     * @param tableName 数据表名
     * @return SQL
     */
    String getTableColumns(String tableName);

    /**
     * 获取字段对应的类型
     * @param tableName 数据表名
     * @param columnName 列名
     * @return SQL
     */
    String getColumnType(String tableName, String columnName);

    /**
     * 获取字段对应的类型
     * @param tableName 数据表名
     * @param columnName 列名
     * @return SQL
     */
    String getColumnComment(String tableName, String columnName);

}
