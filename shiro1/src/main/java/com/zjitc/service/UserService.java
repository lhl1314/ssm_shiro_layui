package com.zjitc.service;

import com.zjitc.pojo.User;

/**客户端用户逻辑层
 * Created with IDEA
 * author:lhl
 * Date:2019/4/4 0004
 * Time:14:59
 */
public interface UserService {
    /**
     * 客户端登录
     * @param username
     * @param password
     * @return
     */
    int  login(String username,String password);


    /**
     * 查找一个用户
     * @param username
     * @return
     */
    User findOne(String username);
}
