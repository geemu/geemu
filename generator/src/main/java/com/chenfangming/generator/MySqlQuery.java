package com.chenfangming.generator;

/**
 * MySql 表数据查询
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-08-18 20:25
 */
public class MySqlQuery extends AbstractDbQuery {

    /**
     * 数据库类型
     */
    @Override
    public DbType getDbType() {
        return DbType.MYSQL;
    }

    /**
     * 获取所有数据表名
     * @return SQL
     */
    @Override
    public String getTableNames() {
        return "SELECT table_name AS 'name'" +
            "FROM information_schema.tables" +
            "WHERE table_schema = (SELECT DATABASE())";
    }

    /**
     * 获取数据表注释
     * @param tableName 数据表名
     * @return SQL
     */
    @Override
    public String getTableComment(String tableName) {
        return "SELECT table_name AS 'name',table_comment AS 'comment'" +
            "FROM information_schema.tables" +
            "WHERE table_schema = (SELECT DATABASE())" +
            "AND table_name= '" + tableName + "'";
    }

    /**
     * 获取数据表所有字段名
     * @param tableName 数据表名
     * @return SQL
     */
    @Override
    public String getTableColumns(String tableName) {
        return "SELECT column_name AS 'name'" +
            "FROM information_schema.columns" +
            "WHERE table_schema = (SELECT DATABASE())" +
            "AND table_name = '" + tableName + "'";
    }

    /**
     * 获取字段对应的类型
     * @param tableName 数据表名
     * @param columnName 列名
     * @return SQL
     */
    @Override
    public String getColumnType(String tableName, String columnName) {
        return "SELECT data_type AS 'type'" +
            "FROM information_schema.columns" +
            "WHERE table_schema = (SELECT DATABASE())" +
            "AND table_name = '" + tableName + "'" +
            "AND column_name = '" + columnName + "'";
    }

    /**
     * 获取字段对应的类型
     * @param tableName 数据表名
     * @param columnName 列名
     * @return SQL
     */
    @Override
    public String getColumnComment(String tableName, String columnName) {
        return "SELECT column_comment AS 'comment'" +
            "FROM information_schema.columns" +
            "WHERE table_schema = (SELECT DATABASE())" +
            "AND table_name = '" + tableName + "'" +
            "AND column_name = '" + columnName + "'";
    }

}
