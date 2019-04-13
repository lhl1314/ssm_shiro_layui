package com.zjitc.controller;

import com.zjitc.pojo.AdminUser;
import com.zjitc.service.AdminUserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/4 0004
 * Time:9:27
 */
@Controller
public class Test2Controller {
    @Autowired
    AdminUserService adminUserService;
    @RequiresAuthentication
    @RequestMapping(value = "/a")
    @ResponseBody
    public String a(){
        return "哈哈哈哈，需要登陆后才可以访问";
    }
    @RequestMapping(value = "/aa")
    @ResponseBody
    public String aa(){
        return "哈哈哈哈，需要登陆后才可以访问";
    }

    /**
     * 必须认证登录才可访问
     * @return
     */
    @RequiresAuthentication//这个路径，身份必须验证后才可以访问这个路径
    @RequestMapping(value = "/test")
    @ResponseBody
    public List<AdminUser> test() {
        return adminUserService.getAll();
    }

    /**
     * 不必认证
     * @return
     */

    @RequiresGuest//只能是未认证登录的游客才可以进行访问
    @RequestMapping(value = "/test1")
    @ResponseBody
    public List<AdminUser>test1(){
        return adminUserService.getAll();
    }

    /**
     * 必须有admin这个角色才可以访问下面的路径
     * @return
     */
    @RequiresRoles(value = {"老板"})
    @RequestMapping(value = "/test2")
    @ResponseBody
    public List<AdminUser>test2(){
        return adminUserService.getAll();
    }

    @RequiresPermissions(value = {"/admin/add","/admin/delete"})
    @RequestMapping(value = "/test3")
    @ResponseBody
    public List<AdminUser>test3(){
        return adminUserService.getAll();
    }
}
