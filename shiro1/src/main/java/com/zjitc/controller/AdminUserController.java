package com.zjitc.controller;

import com.zjitc.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/4 0004
 * Time:9:50
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminUserController {
   @Autowired
    AdminUserService adminUserService;
    @RequestMapping(value = "/login")
    public String Login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password){
        int i = adminUserService.login(username, password);
        return "adminHome";
    }
}
