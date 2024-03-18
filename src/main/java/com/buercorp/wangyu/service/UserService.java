package com.buercorp.wangyu.service;

import com.buercorp.wangyu.pojo.User;

public interface UserService {
    boolean insertUser(User user);

    boolean updateUser(User user);

    User getUser(String username,String password);

    boolean deleteUser(User user);

}
