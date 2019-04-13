package com.zjitc.controller;

import com.zjitc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/4 0004
 * Time:15:08
 */
@Controller
@RequestMapping(value = "/client")
public class ClientUserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login")
    public String client(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password){
        int i = userService.login(username, password);
        return "clientHome";
    }
}
