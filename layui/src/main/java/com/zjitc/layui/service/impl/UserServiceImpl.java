package com.zjitc.layui.service.impl;

import com.github.pagehelper.PageHelper;
import com.zjitc.layui.dao.UserDao;
import com.zjitc.layui.pojo.User;
import com.zjitc.layui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/28 0028
 * Time:17:08
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public List<User> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> all = userDao.getAll();
        return all;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public int deleteUser(int id) {
        userDao.delete(id);
        return 0;
    }
}
