package com.hnist.hotel.service.impls;

import com.alibaba.druid.sql.PagerUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnist.hotel.mapper.CityMapper;
import com.hnist.hotel.mapper.HotelMapper;
import com.hnist.hotel.mapper.RoomTypeMapper;
import com.hnist.hotel.pojo.City;
import com.hnist.hotel.pojo.Hotel;
import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Resource
    HotelMapper hotelMapper;

    @Resource
    CityMapper cityMapper;

    @Override
    public PageInfo queryallhotel(Integer indexpage,String city,Integer userid) {
        if (indexpage==null){
            indexpage=1;
        }
        Example example=new Example(Hotel.class);
        Example.Criteria criteria = example.createCriteria();
        if (city!=null&&!city.equals("null")){
            criteria.andEqualTo("city",city);
        }
        PageHelper.startPage(indexpage,8);
        List<Hotel> hotelList = hotelMapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(hotelList,4);
        if (hotelList!=null&&hotelList.size()>0){
            return pageInfo;
        }
       return null;
    }

    @Override
    public Hotel queryhotelone(Integer hotelid) {
          if (hotelid!=null){
              Hotel hotel = hotelMapper.selectByPrimaryKey(hotelid);
              if (hotel!=null){
                  return hotel;
              }
          }
          return null;
    }

    @Override
    public boolean update(Hotel hotel) {
          if (hotel!=null){
              int i = hotelMapper.updateByPrimaryKeySelective(hotel);
              if (i>0){
                  return true;
              }
          }
          return false;
    }

    @Override
    @Transactional
    public boolean delete(@RequestBody Hotel hotel) {
        if (hotel!=null){
            int i = hotelMapper.delete(hotel);
            if (i>0){
                String cityname = hotel.getCity();
                int j = cityMapper.updatenum(cityname);
                if (j>0){
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean inserthotel(Hotel hotel) {
        if (hotel!=null){
            int i = hotelMapper.insertSelective(hotel);
            if (i>0){
                String cityname = hotel.getCity();
                Example example=new Example(City.class);
                Example.Criteria city = example.createCriteria().andEqualTo("city", cityname);
                City onecity = cityMapper.selectOneByExample(city);
                if (onecity!=null&&onecity.getCityName()!=null){
                    int j = cityMapper.upnum(cityname);
                    if (i>0){
                        return true;
                    }
                }else {
                    City city1=new City();
                    city1.setCityName(cityname);
                    city1.setHotelnum(1);
                    int j = cityMapper.insertSelective(city1);
                    if (j>0){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
