package com.buercorp.wangyu.service.impl;

import com.buercorp.wangyu.pojo.User;
import com.buercorp.wangyu.service.UserService;
import com.buercorp.wangyu.utils.DruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * 业务层实现
 * @author 忆白
 */
public class UserSerice implements UserService {

    @Override
    public boolean insertUser(User user) {
        int row = 0;
        // 使用 BeanUtils.populate 将接收到的参数保存到 user 对象中
        try {
            /**
             * 使用DBUtils将用户信息存储到数据库
             * 这里需要mysql驱动、druid、dbutils的jar包
             * 使用了BeanUtils和DBUtils两个工具类来简化数据处理和数据库操作的过程。
             * 在存储数据到数据库时，使用了QueryRunner类和Druid数据源来进行数据库操作
             */
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "insert into user values (null,?,?,?,?,?,?,?)";
            row = queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getAddress(),
                    user.getNickname(), user.getGender(), user.getEmail(), user.getStatus());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public User getUser(String username, String password) {
        return null;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }
}
