package com.teeth.dao;

import com.teeth.pojo.AdminUser;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/3 0003
 * Time:13:29
 */
public interface AdminUserDao {

    /**
     * 获取所有的管理员
     * @return
     */
    List<AdminUser>getAll();

    /**
     * 通过名称获取管理员
     * @param username
     * @return
     */
    AdminUser findOneByUserName(String username);

    /**
     * 通过id获取管理员
     * @param id
     * @return
     */
    AdminUser getOne(int id);

    /**
     * 添加一个管理员
     * @param adminUser
     */
    void addAdminUser(AdminUser adminUser);

    /**
     * 修改信息
     * @param adminUser
     */
    void updateAdminUser(AdminUser adminUser);

    /**
     * 除了老板角色，其他的管理员，辞退状态下可以删除
     */
    void deleteAdminUser(Integer id);



}
