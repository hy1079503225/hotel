package com.hnist.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.hnist.hotel.pojo.CheckIn;
import com.hnist.hotel.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("checkin")
public class CheckInCotroller {

    private final CheckInService checkInService;
    @Autowired
    public CheckInCotroller(CheckInService checkInService){
        this.checkInService = checkInService;
    }

    @RequestMapping("in")
    public HashMap addCheckIn(String orderId,Integer hotelId,String hotelName,Integer personNumber,String userName,String cardIds){
        CheckIn checkIn = new CheckIn();
        checkIn.setOrderId(orderId);
        checkIn.setHotelId(hotelId);
        checkIn.setHotelName(hotelName);
        checkIn.setPersonNumber(personNumber);
        checkIn.setUserName(userName);
        checkIn.setCardIds(cardIds);
        return checkInService.checkIn(checkIn);
    }

    @RequestMapping("delete")
    public int deleteCheckIn(Integer checkId){
        return checkInService.delete(checkId);
    }

    @RequestMapping("update")
    public int update(Integer checkId,Integer roomNumber){
        CheckIn checkIn = new CheckIn();
        checkIn.setId(checkId);
        checkIn.setRoomNumber(roomNumber);
        return checkInService.update(checkIn);
    }

    @RequestMapping("withid")
    public CheckIn getById(Integer checkId){
        return checkInService.selectById(checkId);
    }

    @RequestMapping("all")
    public String selectAll(Integer indexpage){
        PageInfo pageInfo = checkInService.selectAllCheckIn(indexpage);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String string = objectMapper.writeValueAsString(pageInfo);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
