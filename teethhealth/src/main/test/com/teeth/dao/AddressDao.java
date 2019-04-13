package com.teeth.dao;

import com.teeth.pojo.Area;
import com.teeth.pojo.City;
import com.teeth.pojo.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/12 0012
 * Time:8:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class AddressDao {
    @Autowired AddressChooseDao addressChooseDao;
    @Test
    public void getProvince(){
        List<Province> provinceList = addressChooseDao.getAllProvince(1);
        provinceList.forEach(t-> System.out.println(t));
    }

    @Test
    public void getCity(){
        List<City> cityList = addressChooseDao.getAllCity(1);
        cityList.forEach(t-> System.out.println(t));
    }


    @Test
    public void getArea(){
        List<Area> areaList = addressChooseDao.getAllArea(16);
        areaList.forEach(t-> System.out.println(t));
    }

}
