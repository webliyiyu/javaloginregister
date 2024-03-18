package com.buercorp.wangyu.dao;

import com.buercorp.wangyu.pojo.User;

public interface UserDao {
    boolean deleteUser(int userId);

    boolean insertUser(int userId);

    boolean updateUser(User user);

    User getUser(int userId);
}
