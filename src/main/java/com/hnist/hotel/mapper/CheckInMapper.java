package com.hnist.hotel.mapper;

import com.hnist.hotel.pojo.CheckIn;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CheckInMapper extends Mapper<CheckIn> {
//    int deleteByPrimaryKey(Integer checkInId);

    CheckIn selectByPrimaryKey(Integer checkInId);

    CheckIn selectLastestByRoomNumber(Integer roomNumber);

    int updateByRoomNumber(Integer roomNumber);

    int checkOut(Integer checkInId);

}
