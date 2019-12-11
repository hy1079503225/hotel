package com.hnist.hotel.service;

import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.Room;
import org.springframework.stereotype.Service;


public interface RoomService {
    PageResult<Room> getRoomList(PageParams pageParams, Integer hotelId);
}
