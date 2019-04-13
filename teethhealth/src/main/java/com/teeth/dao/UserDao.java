package com.teeth.dao;

import com.teeth.pojo.User;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/3 0003
 * Time:10:24
 */
public interface UserDao {
    /**
     * 找出客户端的用户
     * @param username
     * @return
     */
    User getOne(String username);

    /**
     * 获取所有的客户端的用户
     * @return
     */
    List<User>getAll();

}
