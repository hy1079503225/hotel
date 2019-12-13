package com.hnist.hotel.controller;

import com.hnist.hotel.pojo.*;
import com.hnist.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Filename
 * @auther 吴星辰;
 * @data 2019/12/10 23:30;
 * @Descripion
 * @Version 1.1.1
 * @Function
 * @History
 */


@RestController
@RequestMapping("room")
public class RoomConller {

    @Autowired
  RoomService roomService;

   @PostMapping("getHotelrooms")
  public ResponseEntity<PageResult<RoomType>> getRoomList(@RequestBody Map<String,Integer> map){
       PageParams pageParams = new PageParams();
       System.out.println(map.get("page")+"酒店id"+ map.get("holtId"));
       pageParams.setLimit(5);
       pageParams.setPage(map.get("page"));

       if (map.get("holtId")!=null&map.get("page")!=null){

           PageResult<RoomType>  pageResult=     roomService.getRoomTypeList(pageParams,map.get("holtId"));
           return ResponseEntity.ok(pageResult);
       }

      return null;
  }


    @PostMapping("getAdminHotelrooms")
    public ResponseEntity<PageResult<Room>> getAdminRoomList(@RequestBody Map<String,Integer> map){
        PageParams pageParams = new PageParams();
        System.out.println(map.get("page")+"userid"+ map.get("userId"));
        pageParams.setLimit(8);
        pageParams.setPage(map.get("page"));

        if (map.get("userId")!=null&map.get("page")!=null){

            PageResult<Room>  pageResult=     roomService.getAdminRoomList(pageParams,map.get("userId"));
            return ResponseEntity.ok(pageResult);
        }

        return null;
    }

    @RequestMapping("getAdminHotelroomTypes")
    public ResponseEntity<PageResult<RoomType>>  getAdminHotelroomTypes(@RequestBody Map<String,Integer> map){

        PageParams pageParams = new PageParams();
        System.out.println(map.get("page")+"userid"+ map.get("userId"));
        pageParams.setLimit(8);
        pageParams.setPage(map.get("page"));

        if (map.get("userId")!=null&map.get("page")!=null){

            PageResult<RoomType>  pageResult=     roomService.getAdminHotelroomTypes(pageParams,map.get("userId"));
            return ResponseEntity.ok(pageResult);
        }
       return null;
    }





    @RequestMapping("delectAdminHotelroom/{roomId}")
    public ResponseEntity<String> delectAdminHotelroom(@PathVariable("roomId") Integer roomId){

       if (roomId!=null){
           return ResponseEntity.ok(roomService.delectAdminHotelroom(roomId));

       }
       return null;
    }


    @RequestMapping("delectAdminHotelroomType/{roomId}")
    public ResponseEntity<String> delectAdminHotelroomType(@PathVariable("roomId") Integer roomTypeId){

        if (roomTypeId!=null){
            return ResponseEntity.ok(roomService.delectAdminHotelroomType(roomTypeId));

        }
        return null;
    }

    @RequestMapping("getUserHotel/{userId}")
   public ResponseEntity<List<Hotel>> getUserHotel(@PathVariable("userId")  Integer userId){
       if (userId!=null){
          return ResponseEntity.ok( roomService.getUserHel(userId));
       }
       return null;
   }

   @RequestMapping("addRoomType")
   public ResponseEntity addRoomType(@RequestBody Map<String,Object> map){
       return roomService.addRoomType(map);
   }

}
