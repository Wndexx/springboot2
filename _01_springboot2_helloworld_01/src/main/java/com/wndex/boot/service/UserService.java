package com.wndex.boot.service;

import com.wndex.boot.bean.User;
import com.wndex.boot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wndexx 2022-09-15 8:24
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUser(String username) {
        return userDao.getUser(username);
    }
}
