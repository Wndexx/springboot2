package com.wndex.boot.controller;

import com.wndex.boot.bean.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wndexx 2022-09-18 8:24
 */
@RestController
public class ParamController {
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> handle01(@PathVariable("id") Integer id,
                                        @PathVariable("username") String username,
                                        @PathVariable Map<String, String> pathVariableMap) {
        Map<String, Object> map = new HashMap<>();
        map.put("PathVariable_car", id);
        map.put("PathVariable_owner", username);
        map.put("PathVariable_map", pathVariableMap);
        return map;
    }

    @GetMapping("/requestHeader")
    public Map<String, Object> handle02(@RequestHeader("User-Agent") String userAgent,
                                        @RequestHeader Map<String, String> m,
                                        @RequestHeader MultiValueMap<String, String> multiValueMap,
                                        @RequestHeader HttpHeaders httpHeaders) {
        Map<String, Object> map = new HashMap<>();
        map.put("RequestHeader_User-Agent", userAgent);
        map.put("RequestHeader_map", m);
        map.put("RequestHeader_multiValueMap", multiValueMap);
        map.put("RequestHeader_httpHeaders", httpHeaders);
        return map;
    }

    @GetMapping("/requestParam")
    public Map<String, Object> handle03(@RequestParam("id") Integer uid,
                                        @RequestParam("username") String usr,
                                        @RequestParam("interests") List<String> interests,
                                        @RequestParam(required = false) Map<String, String> m,
                                        @RequestParam(required = false) MultiValueMap<String, String> multiValueMap) {
        Map<String, Object> map = new HashMap<>();
        map.put("RequestParam_id", uid);
        map.put("RequestParam_username", usr);
        map.put("RequestParam_interests", interests);
        map.put("RequestParam_map", m);
        map.put("RequestParam_multiValueMap", multiValueMap);
        System.out.println(multiValueMap);
        return map;
    }

    @GetMapping("/cookie")
    public String addCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("k1", "v1");
        response.addCookie(cookie);
        return "cookie 添加成功";
    }

    @GetMapping("/cookieValue")
    public Map<String, Object> handle04(@CookieValue("k1") Cookie cookie,
                                        @CookieValue("k1") String cookieValue) {
        Map<String, Object> map = new HashMap<>();
        map.put("CookieValue_k1", cookie);
        map.put("CookieValue_k1Val", cookieValue);
        return map;
    }

    @PostMapping("/requestBody")
    public String handle05(@RequestBody String rb) {
        return rb;
    }

    // /cars/sell;low=34;brand=byd,audi,yd
    // springboot 默认禁用了矩阵变量的功能，手动开启
    // 原理：对于路径的处理，使用 UrlPathHelper 进行解析的
    // removeSemicolonContent（移除分号内容）支持矩阵变量
    @GetMapping("/cars/{sell}")
    public Map<String, Object> carsSell(@PathVariable("sell") String sell,
                                        @MatrixVariable("low") Integer low,
                                        @MatrixVariable("brand") List<String> brand) {
        Map<String, Object> map = new HashMap<>();
        map.put("PathVariable_sell", sell);
        map.put("MatrixVariable_low", low);
        map.put("MatrixVariable_brand", brand);
        return map;
    }

    // /cars/1;age=10/2;age=20
    @GetMapping("/cars/{t1}/{t2}")
    public Map<String, Object> carsSell1(@MatrixVariable(value = "age", pathVar = "t1") Integer age1,
                                         @MatrixVariable(value = "age", pathVar = "t2") Integer age2,
                                         @MatrixVariable Map<String, String> m,
                                         @MatrixVariable(pathVar = "t1") MultiValueMap<String, String> multiValueMap) {
        Map<String, Object> map = new HashMap<>();
        map.put("MatrixVariable_t1_age", age1);
        map.put("MatrixVariable_t2_age", age2);
        map.put("MatrixVariable_map", m);
        map.put("MatrixVariable_multiValueMap", multiValueMap);
        return map;
    }

    @PostMapping("/person")
    public Person person(Person person){
        return person;
    }
}
