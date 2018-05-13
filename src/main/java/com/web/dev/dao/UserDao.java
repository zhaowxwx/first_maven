package com.web.dev.dao;

import com.web.dev.pojo.User;

/**
 * Created by Administrator on 2018/5/13/0013.
 */
public interface UserDao {

    public void insertUser(User user);

    public User selectUserByName(String name);
}
