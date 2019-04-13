package com.zjitc.dao;

import com.zjitc.pojo.User;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/3 0003
 * Time:10:24
 */
public interface UserDao {
    /**
     * 找到所有的用户即包含一对一，也包含一对多
     * @return
     */
    List<User> findAll();

//    /***
//     * 找出一对一的妻子
//     * @return
//     */
//    List<User>findAllOne();

    /**
     * 找出客户端的用户
     * @param username
     * @return
     */
    User getOne(String username);

}
