package com.zjitc.layui.service;

import com.zjitc.layui.pojo.User;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/28 0028
 * Time:17:08
 */
public interface UserService {
    /**
     * 查找分页数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<User>findAll(int pageNum,int pageSize);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(int id);
}
