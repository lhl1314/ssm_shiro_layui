package com.teeth.dao;

import com.teeth.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/4 0004
 * Time:16:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class UserDaoTest {
    @Autowired UserDao userDao;
    @Test
    public void getOne(){
        User one = userDao.getOne("二狗");
        System.out.println(one);
    }
}
