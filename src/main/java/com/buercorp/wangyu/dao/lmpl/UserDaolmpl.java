package com.buercorp.wangyu.dao.lmpl;

import com.buercorp.wangyu.dao.UserDao;
import com.buercorp.wangyu.pojo.User;

public class UserDaolmpl implements UserDao {

    @Override
    public boolean deleteUser(int userId) {
        return false;
    }

    @Override
    public boolean insertUser(int userId) {
        return false;
    }

    @Override
    public boolean updateUser(int userId, String username) {
        return false;
    }

    @Override
    public User getUser(int userId) {
        return null;
    }
}
