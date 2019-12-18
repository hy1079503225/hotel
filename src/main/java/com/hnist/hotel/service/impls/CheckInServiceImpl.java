package com.hnist.hotel.service.impls;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnist.hotel.mapper.CheckInMapper;
import com.hnist.hotel.mapper.OrderMapper;
import com.hnist.hotel.pojo.CheckIn;
import com.hnist.hotel.pojo.Order;
import com.hnist.hotel.service.CheckInService;
import com.hnist.hotel.service.OrderService;
import com.hnist.hotel.service.RoomService;
import com.hnist.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    private CheckInMapper checkInMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RoomService roomService;

    @Override
    public int insert(CheckIn checkIn) {
        return checkInMapper.insert(checkIn);
    }

    @Override
    public HashMap checkIn(CheckIn checkIn) {
        HashMap map = new HashMap();
        int code = 0;
        Order order = orderService.selectById(checkIn.getOrderId());
//        roomService.
        return map;
    }

    @Override
    public int delete(Integer checkInId) {
        return checkInMapper.deleteByPrimaryKey(checkInId);
    }

    @Override
    public int update(CheckIn checkIn) {
        return checkInMapper.updateByPrimaryKeySelective(checkIn);
    }

    @Override
    public int checkOut(Integer roomNumber) {
        return 0;
    }

    @Override
    public int updateByRoomNumber(Integer roomNumber) {
        return checkInMapper.updateByRoomNumber(roomNumber);
    }

    @Override
    public CheckIn selectById(Integer checkInId) {
        return checkInMapper.selectByPrimaryKey(checkInId);
    }

    @Override
    public PageInfo selectAllCheckIn(Integer indexpage) {
        if (indexpage == null){
            indexpage = 1;
        }
        PageHelper.startPage(indexpage,3);
        List<CheckIn> checkIns = checkInMapper.selectAll();
        PageInfo pageInfo = new PageInfo(checkIns);
        return pageInfo;
    }
}
