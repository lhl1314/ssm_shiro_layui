package com.teeth.service;

import com.teeth.pojo.Area;
import com.teeth.pojo.City;
import com.teeth.pojo.Province;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/12 0012
 * Time:8:46
 */
public interface AddressChooseService {

    List<Province> getAllProvince(Integer countryId);

    List<City>getAllCity(Integer provinceId);


    List<Area>getAllArea(Integer cityId);
}
