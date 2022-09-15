package com.wndex.boot.controller;

import com.wndex.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wndexx 2022-09-15 10:29
 */
@RestController
public class PersonController {
    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person() {
        return person;
    }
}
