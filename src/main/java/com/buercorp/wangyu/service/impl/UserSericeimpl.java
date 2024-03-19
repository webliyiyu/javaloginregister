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

    @Override
    public boolean insertUser(User user) {
        UserDaolmpl userDao = new UserDaolmpl();
        userDao.insertUser(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        UserDaolmpl userDao = new UserDaolmpl();
        userDao.updateUser(user);
        return true;
    }

    @Override
    public User getUser(String username, String password) {
        UserDaolmpl userDao = new UserDaolmpl();
        User user = userDao.getUser(username, password);
        return user;
    }

    @Override
    public boolean deleteUser(User user) {
        UserDaolmpl userDao = new UserDaolmpl();
        userDao.deleteUser(user.getId());
        return true;
    }
}
