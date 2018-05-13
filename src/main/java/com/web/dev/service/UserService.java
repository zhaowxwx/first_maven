package com.web.dev.service;

import com.web.dev.dao.UserDao;
import com.web.dev.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/5/13/0013.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void insertUser(User user){
        userDao.insertUser(user);
    }

    public User findUser(String name) {
        return userDao.selectUserByName(name);
    }
}
