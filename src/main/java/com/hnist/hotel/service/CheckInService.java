package com.hnist.hotel.service;

import com.github.pagehelper.PageInfo;
import com.hnist.hotel.pojo.CheckIn;

import java.util.HashMap;

public interface CheckInService {
    int insert(CheckIn checkIn);

    HashMap checkIn(CheckIn checkIn);

    int delete(Integer checkInId);

    int update(CheckIn checkIn);

    int checkOut(Integer roomNumber);

    int updateByRoomNumber(Integer roomNumber);

    CheckIn selectById(Integer checkInId);

   PageInfo selectAllCheckIn(Integer indexpage);

}
