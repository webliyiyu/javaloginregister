package com.buercorp.wangyu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * 数据库链接池工具类
 */
public class DruidUtil {

    private static DataSource dataSource;

    static {
        try {
            //1. 创建Properties对象
            Properties properties = new Properties();
            //2. 将配置文件转换成字节输入流
            InputStream is = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            //3. 使用properties对象加载is
            properties.load(is);
            //druid底层是使用的工厂设计模式，去加载配置文件，创建DruidDataSource对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}