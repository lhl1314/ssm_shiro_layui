package com.teeth.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.teeth.pojo.*;
import com.teeth.service.AddressChooseService;
import com.teeth.service.AdminRoleService;
import com.teeth.service.AdminUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/4 0004
 * Time:9:50
 */
@Controller
@RequestMapping(value = "/admin/adminUser")
public class AdminUserController {
    @Autowired
    AdminUserService adminUserService;
    @Autowired
    AdminRoleService adminRoleService;

    @Autowired
    AddressChooseService addressChooseService;

    /**
     * 后台管理人员的登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login")
    public String Login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password) {
        int i = adminUserService.login(username, password);
        return "adminHome";
    }

    /**
     * 跳转到layui的主页
     *
     * @return
     */
    @RequestMapping(value = "/toLayuiHome")
    public String toLayuiHome() {
        return "/admin/home";
    }

    /**
     * 管理员列表
     *
     * @param pageNum
     * @param pageSize
     */
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public LayuiTableResponse<AdminUser> findAll(
            @RequestParam(name = "page", defaultValue = "1", required = true) int pageNum,
            @RequestParam(name = "limit", defaultValue = "2") int pageSize) {
        List<AdminUser> all = adminUserService.findAll(pageNum, pageSize);
        if (all != null && !all.isEmpty()) {
            PageInfo info = new PageInfo(all);
            LayuiTableResponse response = new LayuiTableResponse();
            response.setCode(0);
            response.setCount((int) info.getTotal());
            response.setData(all);
            return response;
        }
        return null;
    }

    /**
     * 获取某个管理员的详细信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getOneMessage")
    @ResponseBody
    public AdminUser getOneMessage(Integer id) {
        AdminUser one = adminUserService.findOneById(id);
        return one;
    }

    /**
     * 获取自身基本信息
     *
     * @return
     */
    @RequestMapping(value = "/getMySelf")
    @ResponseBody
    public AdminUser getMySelf(Integer id) {
        AdminUser one = adminUserService.findOneById(id);
        return one;
    }


    /**
     * 修改自身详细信息
     *
     * @param adminUser
     */
    @RequestMapping(value = "/updateAdminMySelf")
    @ResponseBody
    public Integer updateAdminMySelf(@ModelAttribute AdminUser adminUser) {
//         AdminUser data = JSON.parseObject(adminUser, AdminUser.class);
        AdminUser user = adminUserService.findOneById(adminUser.getId());
        if (user.getUsername().equals(adminUser.getUsername())){
            adminUserService.updateMySelf(adminUser);
            return 1; //修改成功！
        }else {
            return 0;//用戶名已經存在了，請重新更換！
        }

    }

    /**
     * 辞退一个管理员
     *
     * @return
     */
    @RequestMapping(value = "/ciTuiAdminUser")
    @ResponseBody
    public Integer ciTuiAdminUser(Integer id) {
        Integer integer = adminUserService.ciTuiAdminUser(id);
        return integer;
    }

    /**
     * 删除一个管理员
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteAdminUser")
    @ResponseBody
    public Integer deleteAdminUser(Integer id) {
        return adminUserService.deleteAdminUser(id);
    }


    /**
     * 获取所有的角色
     *
     * @return
     */
    @RequestMapping(value = "/getAllRoles")
    @ResponseBody
    public List<Role> getAllRoles() {
        return adminRoleService.getAll();
    }

    /**
     * 根据角色获取权限
     *
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/getPermissionByRoleId")
    @ResponseBody
    public Role getPermissionByRoleId(Integer roleId) {
        Role permissions = adminRoleService.getPermissionsByRoleId(roleId);
        return permissions;
    }

    /**
     * 添加一个管理员
     *
     * @param
     */
    @RequestMapping(value = "/addAdminUser")
    @ResponseBody
    public Integer addAdminUser(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "addAdminRoleList") String addAdminRoleList) {
        AdminUser one = adminUserService.findOne(username);
        if (one!=null){
            return 0;
        }
        adminUserService.addAdminUser(username, password, addAdminRoleList);
        System.out.println(username + "-----" + password + "-----" + addAdminRoleList);
        return 1;
    }

    /**
     * 这个修改主要是修改管理员的角色，个人信息不能修改
     * 先删除之前的，重新添加新的角色
     *
     * @return
     */
    @RequestMapping(value = "/AdminUpdateAdminUser")
    @ResponseBody
    public Integer AdminUpdateAdminUser(
            @RequestParam(name = "id") Integer id,
            @RequestParam(name = "updateAdminRoleList") String updateAdminRoleList) {
        adminUserService.updateAdminUserRoles(id, updateAdminRoleList);
        System.out.println(id + "账户id和角色列表" + updateAdminRoleList);
        return 1;
    }

    /**
     * 获取二级地区
     *
     * @return
     */
    @RequestMapping(value = "/GetProvince")
    @ResponseBody
    public List<Province> getProvince() {
        List<Province> allProvince = addressChooseService.getAllProvince(1);
        return allProvince;
    }

    /**
     * 获取三级地区
     *
     * @param provinceId
     * @return
     */
    @RequestMapping(value = "/GetCity")
    @ResponseBody
    public List<City> getCity(Integer provinceId) {
        return addressChooseService.getAllCity(provinceId);
    }

    /**
     * 获取四级地区
     *
     * @param cityId
     * @return
     */
    @RequestMapping(value = "/GetArea")
    @ResponseBody
    public List<Area> getArea(Integer cityId) {
        return addressChooseService.getAllArea(cityId);
    }


}
