package com.wndex.boot.controller;

import com.wndex.boot.bean.User;
import com.wndex.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wndexx 2022-09-15 1:03
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello() {
        return "hello, springboot2!";
    }

    @RequestMapping("/hello01")
    public String hello01() {
        return "hello01";
    }
}
