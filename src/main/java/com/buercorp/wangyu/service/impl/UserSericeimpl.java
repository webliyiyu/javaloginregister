package com.buercorp.wangyu.service.impl;

import com.buercorp.wangyu.dao.impl.UserDaolmpl;
import com.buercorp.wangyu.pojo.User;
import com.buercorp.wangyu.service.UserService;

/**
 * 业务层实现
 *
 * @author 忆白
 */
public class UserSericeimpl implements UserService {
    public UserDaolmpl userDao = new UserDaolmpl();
    @Override
    public boolean insertUser(User user) {
//        UserDaolmpl userDao = new UserDaolmpl();
//        userDao.insertUser(user);
        userDao.insertUser(user);
        return true;
    }

    @Override
    public boolean updateUser(User user, int id) {
        userDao.updateUser(user, id);
        return true;
    }

    @Override
    public User getUser(String username, String password) {
        User user = userDao.getUser(username, password);
        return user;
    }

    @Override
    public boolean deleteUser(int userId) {
        userDao.deleteUser(userId);
        return true;
    }
}
