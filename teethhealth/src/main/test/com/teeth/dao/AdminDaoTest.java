package com.teeth.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.teeth.pojo.AdminUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/4 0004
 * Time:16:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class AdminDaoTest {
    @Autowired AdminUserDao adminUserDao;

    /**
     * 获取所有管理员信息
     */
    @Test
    public void getAll(){
        List<AdminUser> all = adminUserDao.getAll();
        all.forEach(t-> System.out.println(t));
    }

    /**
     * 获取一个
     */
    @Test
    public void getOne(){
        AdminUser one = adminUserDao.getOne(1);
        System.out.println("----"+one);
    }

    @Test
    public void addAdmin(){
        AdminUser user=new AdminUser();
        user.setUsername("哈哈哈");
        user.setPassword("123445");
        adminUserDao.addAdminUser(user);
        System.out.println(user);
        user.setEmail("fasdfas");
        adminUserDao.updateAdminUser(user);
        System.out.println(user);
    }

    @Test
    public void getll(){
        PageHelper.startPage(1,2);
        List<AdminUser> all = adminUserDao.getAll();
        all.forEach(t-> System.out.println(t));
        PageInfo info=new PageInfo(all);
        System.out.println(info);
    }
}
