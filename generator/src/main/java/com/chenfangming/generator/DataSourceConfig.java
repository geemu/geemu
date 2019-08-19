package com.chenfangming.generator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库配置
 * @author YangHu
 * @since 2016/8/30
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceConfig {

    /** 数据库信息查询 **/
    private IDbQuery dbQuery;
    /** 数据库类型 **/
    private DbType dbType;
    /** 驱动连接的URL **/
    private String url;
    /** 驱动名称 **/
    private String driverName;
    /** 数据库连接用户名 **/
    private String username;
    /** 数据库连接密码 **/
    private String password;

    /**
     * 创建数据库连接对象
     * @return Connection
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            log.error("创建数据库连接异常:", e);
        }
        return connection;
    }

}
