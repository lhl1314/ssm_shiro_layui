package com.zjitc.dao;

import com.zjitc.pojo.Role;
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
 * Time:9:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class RoleDaoTest {
    @Autowired RoleDao roleDao;
    @Test
    public void getAllRole(){
        List<Role> all = roleDao.getAll();
        all.forEach(t-> System.out.println(t));
    }
}
