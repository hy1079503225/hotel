package com.hnist.hotel.service;

import com.github.pagehelper.PageInfo;
import com.hnist.hotel.pojo.City;

import java.util.List;

public interface CityService {
      List<City> queryshowcity();
      PageInfo queryallcity(Integer indexpage);
      boolean addcity(City city);
      boolean deleteCity(Integer cityid);
      boolean updateCity(City city);
      City querycityone(Integer id);
}
