package com.zjitc.service;

import com.zjitc.pojo.AdminUser;
import com.zjitc.pojo.User;

import java.util.List;
import java.util.Set;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/4 0004
 * Time:9:42
 */
public interface AdminUserService {

    List<AdminUser>getAll();

    int  login(String username,String password);


    AdminUser findOne(String username);


    /**
     * 找到该用户的所有角色
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 找到该用户的所有权限
     * @param username
     */
    Set<String> findPermissions(String username);
}
