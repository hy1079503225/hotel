package com.hnist.hotel.service;

import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.Room;
import com.hnist.hotel.pojo.RoomType;
import org.springframework.stereotype.Service;


public interface RoomService {
    PageResult<RoomType> getRoomTypeList(PageParams pageParams, Integer hotelId);

    PageResult<Room> getAdminRoomList(PageParams pageParams, Integer userId);
}
