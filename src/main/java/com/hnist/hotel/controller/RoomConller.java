package com.hnist.hotel.controller;

import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.Room;
import com.hnist.hotel.pojo.RoomType;
import com.hnist.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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





}
