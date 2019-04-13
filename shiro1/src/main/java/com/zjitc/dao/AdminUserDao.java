package com.zjitc.dao;

import com.zjitc.pojo.AdminUser;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/3 0003
 * Time:13:29
 */
public interface AdminUserDao {
    List<AdminUser>getAll();

    AdminUser findOneByUserName(String username);
}
