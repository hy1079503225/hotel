package com.hnist.hotel.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hnist.hotel.mapper.HotelMapper;
import com.hnist.hotel.pojo.Hotel;
import com.hnist.hotel.pojo.PageResult;

import java.util.List;

public interface HotelService {
      PageInfo queryallhotel(Integer indexpage, String city,Integer userid);
      Hotel queryhotelone(Integer hotelid);
      boolean update(Hotel hotel);
      boolean delete(Hotel hotel);
      boolean inserthotel(Hotel hotel);
}
