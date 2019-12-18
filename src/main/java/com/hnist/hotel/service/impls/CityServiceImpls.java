package com.hnist.hotel.service.impls;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnist.hotel.mapper.CityMapper;
import com.hnist.hotel.pojo.City;
import com.hnist.hotel.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CityServiceImpls implements CityService {

    @Resource(type = CityMapper.class)
    CityMapper cityMapper;

    @Override
    public List<City> queryshowcity() {
        List<City> cities = cityMapper.selectAll();
        if (cities!=null&&cities.size()>0){
            return cities;
        }
        return null;
    }

    @Override
    public PageInfo queryallcity(Integer indexpage) {
        if (indexpage==null){
            indexpage=1;
        }
        PageHelper.startPage(indexpage,9);
        List list = cityMapper.selectAll();
        PageInfo pageInfo=new PageInfo(list);
        if (list!=null&&list.size()>0){
            return pageInfo;
        }
        return null;
    }

    @Override
    public boolean addcity(City city) {
        int i = cityMapper.insertSelective(city);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCity(Integer cityid) {
        City city = cityMapper.selectByPrimaryKey(cityid);
        if (city.getHotelnum()>0){
            return false;
        }else {
            int i = cityMapper.deleteByPrimaryKey(cityid);
            if (i>0){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public boolean updateCity(City city) {
        if (city!=null){
            int i = cityMapper.updateByPrimaryKeySelective(city);
            if (i>0){
                return true;
            }
        }
        return false;
    }

    @Override
    public City querycityone(Integer id) {
        if (id!=null){
            City cityOne = cityMapper.selectByPrimaryKey(id);
            return cityOne;
        }
         return null;
    }
}
