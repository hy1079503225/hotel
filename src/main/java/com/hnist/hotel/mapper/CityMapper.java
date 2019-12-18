package com.hnist.hotel.mapper;

import com.hnist.hotel.pojo.City;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface CityMapper extends Mapper<City> {

    @Update(value = "update city set hotel_num=hotel_num-1 where city_name={#cityname}")
    public  int updatenum(String cityname);

    @Update(value = "update city set hotel_num=hotel_num+1 where city_name={#cityname}")
    public int upnum(String cityname);
}
