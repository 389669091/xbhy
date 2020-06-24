package com.hxh.utils;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * @auth hxh
 * @date 2020/6/23 0:20
 * @Description
 */
public class DBUtil {
    private static DruidDataSource dataSource;
    static {
        try {

            Properties properties=new Properties();
            InputStream is=DruidDataSource.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);
            dataSource=new DruidDataSource();
            dataSource.setUsername(properties.getProperty("jdbc.username"));
            dataSource.setPassword(properties.getProperty("jdbc.password"));
            dataSource.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
            dataSource.setUrl(properties.getProperty("jdbc.url"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
