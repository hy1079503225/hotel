package com.hnist.hotel.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hnist.hotel.mapper.HotelMapper;
import com.hnist.hotel.pojo.Hotel;
import com.hnist.hotel.pojo.PageResult;

import java.util.List;

public interface HotelService {
      PageInfo queryallhotel(Integer indexpage, String city);
      Hotel queryhotelone(Integer hotelid);
      boolean update(Hotel hotel);
      boolean delete(Integer hotelid);
      boolean inserthotel(Hotel hotel);
}
