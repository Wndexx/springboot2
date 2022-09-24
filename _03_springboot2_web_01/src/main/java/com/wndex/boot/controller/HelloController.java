package com.wndex.boot.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author wndexx 2022-09-15 14:40
 */
@RestController
public class HelloController {
    // @RequestMapping("/Fb5l5MUUEAAjOsI.jpg")
    // public String handle01() {
    //     return "handle01";
    // }

    // @RequestMapping("/")
    // public String index() {
    //     return "欢迎";
    // }

    // @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser() {
        return "GET-张三";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser() {
        return "POST-张三";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser() {
        return "PUT-张三";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser() {
        return "DELETE-张三";
    }

    // 扩展点：如何更换 _method 这个名字
}
