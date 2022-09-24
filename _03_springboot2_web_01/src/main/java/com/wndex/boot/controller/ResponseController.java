package com.wndex.boot.controller;

import com.wndex.boot.bean.Person;
import com.wndex.boot.bean.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wndexx 2022-09-21 13:09
 */
@RequestMapping("/resp")
@Controller
public class ResponseController {
    @ResponseBody
    @GetMapping("/person")
    public Person getPerson() {
        return new Person("张三", 20, new Date(92, Calendar.NOVEMBER, 11), new Pet("猫咪", 1));
    }

    @ResponseBody
    @GetMapping("/ss")
    public String ss(){
        return "你好";
    }
}
