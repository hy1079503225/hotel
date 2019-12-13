package com.hnist.hotel.service;

import com.hnist.hotel.pojo.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface RoomService {
    PageResult<RoomType> getRoomTypeList(PageParams pageParams, Integer hotelId);

    PageResult<Room> getAdminRoomList(PageParams pageParams, Integer userId);

    String delectAdminHotelroom(Integer roomId);

    PageResult<RoomType> getAdminHotelroomTypes(PageParams pageParams, Integer userId);

    String delectAdminHotelroomType(Integer roomTypeId);

    List<Hotel> getUserHel(Integer userId);

    ResponseEntity addRoomType(Map<String, Object> map);
}
