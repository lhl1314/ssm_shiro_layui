package com.zjitc.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/3 0003
 * Time:14:52
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "/toLogin")
    public String login(){
        return "index";
    }



   @RequestMapping(value = "/index11")
    public String index(){
        return "index1";
    }
    @RequestMapping(value = "/index2")
    public String index2(){
        return "index2";
    }

    @RequestMapping(value = "/index3")
    @ResponseBody
    public String index3(){
       return "这是啥呢么贵afasd";
    }

    @RequestMapping(value = "/hello")
    public String hello(Model model){
       model.addAttribute("hello","Hello World");

       return "hello";
    }


    @RequestMapping(value = "/index4")
    public String index4(){
       return "index4";
    }
}
