package com.buercorp.wangyu.dao.impl;

import com.buercorp.wangyu.dao.UserDao;
import com.buercorp.wangyu.pojo.User;
import com.buercorp.wangyu.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

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
    public boolean insertUser(int userId) {

        return false;
    }

    @Override
    public boolean updateUser(User user) {
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "update user set name=?,password=?,address=?,nickname=?,gender=?,email=? Where id=?";
        int update = 0;
        //将user用户存储的数据 插入 到数据库中
        try {
            update = queryRunner.update(sql, User.getUsername(), user.getPassword(), user.getAddress(),
                    user.getNickname(), user.getGender(), user.getEmail(), user.getStatus());
            User newUser = new User(user.getId(), user.getNickname(), user.getAddress(), user.getGender(), user.getEmail(), user.getPassword(), user.getUsername());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return update > 0;

    }

    @Override
    public User getUser(int userId) {
        return null;
    }
}
