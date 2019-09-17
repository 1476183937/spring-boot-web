package com.atguigu.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String index(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好！</h1>");
        ArrayList users = new ArrayList();
        users.add("shangsan");
        users.add("lisi");
        users.add("wangwu");
        map.put("users",users);
        return "success";
    }
}
