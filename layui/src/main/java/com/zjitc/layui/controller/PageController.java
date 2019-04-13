package com.zjitc.layui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/28 0028
 * Time:16:42
 */
@RestController
public class PageController {
    @RequestMapping(value = "/hello1")
    public String hello(){
        return "index";
    }
}
