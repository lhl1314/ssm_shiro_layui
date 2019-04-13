package com.zjitc.dao;

import com.zjitc.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/3 0003
 * Time:10:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class UserDaoTest {
    @Autowired UserDao userDao;
    @Test
    public void getALL(){
        List<User> all = userDao.findAll();
        all.forEach(t-> System.out.println(t));
    }
}
