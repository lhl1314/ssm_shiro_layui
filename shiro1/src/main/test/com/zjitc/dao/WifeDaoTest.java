package com.zjitc.dao;

import com.zjitc.pojo.Wife;
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
 * Time:10:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class WifeDaoTest {
    @Autowired WifeDao wifeDao;
    @Test
    public void getAll(){
        List<Wife> all = wifeDao.getALL();
        all.forEach(t-> System.out.println(t));
    }
}
