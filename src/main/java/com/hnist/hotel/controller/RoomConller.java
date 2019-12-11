package com.hnist.hotel.controller;

import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.Room;
import com.hnist.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

   @RequestMapping("getHotelrooms")
  public ResponseEntity<PageResult<Room>> getRoomList(@RequestParam Integer hotelId,@RequestParam Integer page){
       PageParams pageParams = new PageParams();
       pageParams.setLimit(5);
       pageParams.setPage(page);
       System.out.println(hotelId+page);
       if (hotelId!=null&page!=null){

           PageResult<Room>  pageResult=     roomService.getRoomList(pageParams,hotelId);
           return ResponseEntity.ok(pageResult);
       }

      return null;
  }



}
