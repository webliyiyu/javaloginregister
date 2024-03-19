package com.buercorp.wangyu.dao;

import com.buercorp.wangyu.pojo.User;

public interface UserDao {
    boolean deleteUser(int userId);

    boolean insertUser(User user);

    boolean updateUser(User user);

    User getUser(String username, String password);
}
