package com.wndex.boot.controller;

import com.wndex.boot.bean.User;
import com.wndex.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wndexx 2022-09-15 8:32
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public User user(@RequestParam("uname") String username) {
        log.info("开始处理请求......");
        return userService.getUser(username);
    }
}
