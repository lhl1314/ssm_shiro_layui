package com.zjitc.layui.controller;

import com.github.pagehelper.PageInfo;
import com.zjitc.layui.pojo.LayuiTableResponse;
import com.zjitc.layui.pojo.User;
import com.zjitc.layui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/29 0029
 * Time:8:50
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 因为加入了springBoot的模板thymeleaf可以直接返回到页面
     * @return
     */
    @RequestMapping(value = "/hello")
    public String hello(){
        return "a/hello";
    }

    @RequestMapping(value = "/findByPageNum")
    public String getUser(
            @RequestParam(name = "pageNum",defaultValue = "1",required = true) int pageNum,
            @RequestParam(name = "pageSize",defaultValue = "2",required = false) int pageSize,
            Model model){
        List<User> all = userService.findAll(pageNum, pageSize);
        PageInfo page=new PageInfo(all);
        model.addAttribute("page",page);
        return "user/user";
    }

    /**
     * layui的分页获取
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/findLayuiPage")
    @ResponseBody
    public LayuiTableResponse<User> findUserLayuiPage(
            @RequestParam(name = "page",defaultValue = "1",required = true) int pageNum,
            @RequestParam(name = "limit",defaultValue = "10",required = false) int pageSize){
        List<User> users = userService.findAll(pageNum, pageSize);
        PageInfo info=new PageInfo(users);
        LayuiTableResponse<User>response=new LayuiTableResponse<>();
        response.setMsg("");
        response.setCode(0);
        response.setData(users);
        response.setCount((int) info.getTotal());
        return response;
    }

    @RequestMapping(value = "/addUser")
    @ResponseBody
    public String addUser(User user){
        userService.add(user);
        return "添加用户成功";
    }


    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public Integer deleteUser(int id){
        userService.deleteUser(id);
        return 1;
    }
}
