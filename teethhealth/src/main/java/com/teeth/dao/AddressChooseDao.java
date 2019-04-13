package com.teeth.dao;

import com.teeth.pojo.Area;
import com.teeth.pojo.City;
import com.teeth.pojo.Province;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/12 0012
 * Time:8:22
 */
public interface AddressChooseDao {
    /**
     * 获取中国的二级地区列表
     * @param countryId
     * @return
     */
    List<Province>getAllProvince(Integer countryId);

    /**
     * 获取三级地区列表
     * @param provinceId
     * @return
     */
    List<City>getAllCity(Integer provinceId);

    /**
     * 获取四级地区列表
     * @param cityId
     * @return
     */
    List<Area>getAllArea(Integer cityId);


    /**
     * 获取某个二级地区
     * @param provinceId
     * @return
     */
    Province getOneProvince(Integer provinceId);

    /**
     * 获取某个三级地区
     * @param cityId
     * @return
     */
    City getOneCity(Integer cityId);

    /**
     * 获取某个四级地区
     * @param areaId
     * @return
     */
    Area getOneArea(Integer areaId);
}
