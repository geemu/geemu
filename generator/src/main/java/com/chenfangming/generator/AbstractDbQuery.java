package com.chenfangming.generator;

/**
 * 表数据查询抽象类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-08-18 20:18
 */
public abstract class AbstractDbQuery {

    /**
     * 数据库类型
     */
    public abstract DbType getDbType();

    /**
     * 获取所有数据表名
     * @return SQL
     */
    public abstract String getTableNames();

    /**
     * 获取数据表注释
     * @param tableName 数据表名
     * @return SQL
     */
    public abstract String getTableComment(String tableName);

    /**
     * 获取数据表所有字段名
     * @param tableName 数据表名
     * @return SQL
     */
    public abstract String getTableColumns(String tableName);

    /**
     * 获取字段对应的类型
     * @param tableName 数据表名
     * @param columnName 列名
     * @return SQL
     */
    public abstract String getColumnType(String tableName, String columnName);

    /**
     * 获取字段对应的类型
     * @param tableName 数据表名
     * @param columnName 列名
     * @return SQL
     */
    public abstract String getColumnComment(String tableName, String columnName);

}
