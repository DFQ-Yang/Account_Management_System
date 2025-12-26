package com.dimo.account_management_system_javaee.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class dbPoolInitializerUtil {

    private static final HikariDataSource dataSource;

    static{
        HikariConfig config = new HikariConfig();

        config.setDriverClassName(appPropLoaderUtil.get("jdbc.driver"));
        config.setJdbcUrl(appPropLoaderUtil.get("jdbc.url"));
        config.setUsername(appPropLoaderUtil.get("jdbc.username"));
        config.setPassword(appPropLoaderUtil.get("jdbc.password"));

        config.setMaximumPoolSize(Integer.parseInt(appPropLoaderUtil.get("pool.maxSize")));
        config.setMinimumIdle(Integer.parseInt(appPropLoaderUtil.get("pool.minIdel")));
        config.setConnectionTimeout(Long.parseLong(appPropLoaderUtil.get("pool.maxConnectionTime")));

        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
