package com.buercorp.wangyu.dao;

import com.buercorp.wangyu.pojo.User;

public interface UserDao {
    boolean deleteUser(int userId);

    boolean insertUser(int userId);

    boolean updateUser(int userId, String username);

    User getUser(int userId);
}
