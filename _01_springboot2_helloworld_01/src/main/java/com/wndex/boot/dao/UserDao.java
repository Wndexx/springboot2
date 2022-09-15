package com.wndex.boot.dao;

import com.wndex.boot.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @author wndexx 2022-09-15 8:25
 */
@Repository
public class UserDao {
    public User getUser(String username) {
        return new User("张三", 20);
    }
}
