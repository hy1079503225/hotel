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

    ResponseEntity<List<String>> addRoomType(Map<String, Object> map);

    ResponseEntity<RoomType> getOneRoomType(Integer roomTypeId);

    ResponseEntity<List<String>> updateRoomType(Map<String, Object> map);

    List<RoomType> getUserHoteltyoes(Integer hotleId);

    ResponseEntity<List<String>> addRoom(Map<String, Object> map);

    ResponseEntity<Map<String, Object>> getOneRoomAndtype(Map<String, Object> map);

    ResponseEntity<List<String>> updateRoom(Map<String, Object> map);

    ResponseEntity<List<String>> deleteroomids(String roomIds);

    ResponseEntity<List<String>> deleteroomtypeids(String roomIds);
}
