package com.buercorp.wangyu.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DruidUtilTest {
    @Test
    public void getDataSource() throws SQLException {
        // 获取druid的数据库连接池
        DataSource dataSource = DruidUtil.getDataSource();

        //测试插入数据
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "insert into user(`username`, `password`, `address`, `nickname`, `gender`, `email`) values (?,?,?,?,?,?)";

        //将user用户存储的数据 插入 到数据库中
        int i = queryRunner.update(sql, "liyiyu", "123123", "深圳", "kkkk", "male", "123@qq.com");
        System.out.println("插入的数据行数: " + i);
    }

}
