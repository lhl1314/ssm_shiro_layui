package com.teeth.dao;

import com.teeth.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/9 0009
 * Time:14:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class RolePermissionDaoTest {
    @Autowired RolePermissionDao rolePermissionDao;
   @Test
    public void getAllRoles(){
        List<Role> allRoles = rolePermissionDao.getAllRoles();
        allRoles.forEach(t-> System.out.println(t));
    }

    @Test
    public void getOneRolePermission(){
        Role a = rolePermissionDao.getAllPermissionByRoleId(1);
        System.out.println(a);
    }
}
