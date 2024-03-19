package com.buercorp.wangyu.dao.impl;

import com.buercorp.wangyu.dao.UserDao;
import com.buercorp.wangyu.pojo.User;
import com.buercorp.wangyu.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @Description: 用户数据访问层实现类
 * @Version: 1.0
 * @Author: yibai
 */
public class UserDaolmpl implements UserDao {
    @Override
    public boolean deleteUser(int userId) {
        // 连接数据库校验用户名和密码，也就是执行查询的SQL语句
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "DELETE FROM user WHERE id = ?";
        int count = 0;
        try {
            // 使用QueryRunner类的update方法执行SQL更新语句
            // 执行成功返回的是影响的行数
            count = queryRunner.update(sql, userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count > 0;
    }

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
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "update user set name=?,password=?,address=?,nickname=?,gender=?,email=? Where id=?";
        int update = 0;
        //将user用户存储的数据 插入 到数据库中
        try {
            update = queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getAddress(),
                    user.getNickname(), user.getGender(), user.getEmail(), user.getStatus());
//            User newUser = new User(user.getId(), user.getNickname(), user.getAddress(), user.getGender(), user.getEmail(), user.getPassword(), user.getUsername());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return update > 0;

    }

    @Override
    public User getUser(String username, String password) {
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "select * from user where username=? and password=?";
        User user;
        try {
            //执行查询，查询一条数据，封装到User中
            user = queryRunner.query(sql, new BeanHandler<>(User.class), username, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
