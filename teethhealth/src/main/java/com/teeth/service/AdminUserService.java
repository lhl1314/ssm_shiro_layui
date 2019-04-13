package com.teeth.service;

import com.teeth.pojo.AdminUser;


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

    int  login(String username, String password);


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


    /**
     * 找到所有的用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<AdminUser>findAll(int pageNum,int pageSize);


    /**
     * 找到某个管理员的详细信息
     * @param id
     * @return
     */
    AdminUser findOneById(int id);

    /**
     * 自身修改个人信息
     * @param adminUser
     */
    void updateMySelf(AdminUser adminUser);

    /**
     * 辞退某个管理员，将status字段修改为0
     * @param id
     */
    Integer ciTuiAdminUser(int id);

    /**
     * 删除一个管理员
     * @param id
     * @return
     */
    Integer deleteAdminUser(int id);


    /**
     * 添加某个管理员
     * @param username
     * @param password
     * @param addAdminRoleList、、角色1,2,3
     */
    void addAdminUser(String username,String password,String addAdminRoleList);


    /**
     * 修改管理员的角色信息
     * @param id
     * @param updateAdminRoleList
     */
    void updateAdminUserRoles(Integer id,String updateAdminRoleList);
}
