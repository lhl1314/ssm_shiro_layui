package com.teeth.controller;

import com.teeth.dao.AdminUserDao;
import com.teeth.pojo.AdminUser;
import com.teeth.pojo.ResponseData;
import com.teeth.service.UserService;
import com.teeth.utils.Utils;
import com.teeth.utils.UtilsShiro;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/4 0004
 * Time:16:39
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    AdminUserDao adminUserDao;

    /**
     * 获取json的数据
     * @return
     */
    @RequestMapping(value = "/getGson")
    @ResponseBody
    public ResponseData<List<AdminUser>> getGson(){
        List<AdminUser> all = adminUserDao.getAll();
        ResponseData data=new ResponseData();
        data.setCode(1);
        data.setMsg("统一格式的json数据");
        data.setData(all);
        return data;
    }

    /**
     * 必须认证登录才可访问
     * @return
     */
    @RequiresAuthentication//这个路径，身份必须验证后才可以访问这个路径
    @RequestMapping(value = "/mustLogin")
    @ResponseBody
    public List<AdminUser> test() {
        return adminUserDao.getAll();
    }

    /**
     * 不必认证
     * @return
     */

    @RequiresGuest//只能是未认证登录的游客才可以进行访问
    @RequestMapping(value = "/noMustLogin")
    @ResponseBody
    public List<AdminUser>test1(){
        return adminUserDao.getAll();
    }

    /**
     * 必须有admin这个角色才可以访问下面的路径
     * @return
     */
    @RequiresRoles(value = {"老板"})
    @RequestMapping(value = "/mustHaveRole")
    @ResponseBody
    public List<AdminUser>test2(){
        return adminUserDao.getAll();
    }

    @RequiresPermissions(value = {"用户管理","商品管理"})
    @RequestMapping(value = "/havePermissions")
    @ResponseBody
    public List<AdminUser>test3(){
        return adminUserDao.getAll();
    }


    @RequestMapping(value = "/toTable")
    public String toTable(){
        return "table";
    }


    /**
     * shiro 中     * AES算法的加密解密
     * @param msg
     * @return
     */
    @RequestMapping(value = "jiami")
    @ResponseBody
    public String jiami(String msg){
        String hello = UtilsShiro.jiaMi(1,msg);
        return hello;
    }

    /**
     * 解密
     * @param msg
     * @return
     */
    @RequestMapping(value = "/jiemi")
    @ResponseBody
    public String jiemi(String msg){
        String s = UtilsShiro.jieMi(msg);
        return s;
    }



}
