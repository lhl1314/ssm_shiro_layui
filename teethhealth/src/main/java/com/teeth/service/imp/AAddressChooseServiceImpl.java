package com.teeth.service.imp;

import com.teeth.dao.AddressChooseDao;
import com.teeth.pojo.Area;
import com.teeth.pojo.City;
import com.teeth.pojo.Province;
import com.teeth.service.AddressChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/12 0012
 * Time:8:47
 */
@Service
public class AAddressChooseServiceImpl implements AddressChooseService {
    @Autowired
    AddressChooseDao addressChooseDao;
    @Override
    public List<Province> getAllProvince(Integer countryId) {
        return addressChooseDao.getAllProvince(countryId);
    }

    @Override
    public List<City> getAllCity(Integer provinceId) {
        return addressChooseDao.getAllCity(provinceId);
    }

    @Override
    public List<Area> getAllArea(Integer cityId) {
        return addressChooseDao.getAllArea(cityId);
    }
}
