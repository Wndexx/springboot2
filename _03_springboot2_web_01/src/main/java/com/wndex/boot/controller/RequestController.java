package com.wndex.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wndexx 2022-09-18 10:25
 */
@Controller
public class RequestController {
    @GetMapping("/reqAttr01")
    public String handle01(HttpServletRequest request) {
        request.setAttribute("username", "zhangsan");
        return "forward:/reqAttr02";
    }

    @ResponseBody
    @GetMapping("/reqAttr02")
    public Map<String, Object> handle02(@RequestAttribute("username") String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("RequestAttribute_username", username);
        return map;
    }

    @GetMapping("/testModelAndMap01")
    public String testModelAndMap01(Map<String, Object> map,
                                    Model model,
                                    ModelMap modelMap) {
        map.put("Map", "map");
        model.addAttribute("Model", "model");
        modelMap.addAttribute("ModelMap", "modelMap");
        return "forward:/testModelAndMap02";
    }

    @ResponseBody
    @GetMapping("/testModelAndMap02")
    public Map<String, Object> testModelAndMap02(HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("0", request.getAttribute("Map"));
        map.put("1", request.getAttribute("Model"));
        map.put("2", request.getAttribute("ModelMap"));
        return map;
    }
}
