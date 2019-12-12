package com.hnist.hotel.service.impls;

import com.alibaba.druid.sql.PagerUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnist.hotel.mapper.HotelMapper;
import com.hnist.hotel.pojo.Hotel;
import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.service.HotelService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Resource
    HotelMapper hotelMapper;
    @Override
    public PageInfo queryallhotel(Integer indexpage,String city) {
        if (indexpage==null){
            indexpage=1;
        }
        Example example=new Example(Hotel.class);
        example.createCriteria().andEqualTo("city",city);
        PageHelper.startPage(indexpage,8);
        List<Hotel> hotelList = hotelMapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(hotelList,3);
        if (hotelList!=null&&hotelList.size()>0){
            return pageInfo;
        }
       return null;
    }
}
