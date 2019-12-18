package com.hnist.hotel.mapper;

import com.hnist.hotel.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface OrderMapper extends Mapper<Order> {

    @Insert("insert into order values(#{id},#{hotel_id},#{room_type},#{room_number},#{order_date},#{order_days},#{order_status},#{order_cost},#{create_time},#{user_id},#{user_username},#{user_phone},#{user_cardid})")
    Order addOrder(Order order);

    @Update("update room_roomtype set num = num - 1 where roomtype_id = #{roomTypeId}")
    int uodateRoomNum(Integer roomTypeId);

    Order selectByNameAndPhone(Order order);

    List<Order> selectByUserId(Integer userId);

    List<Order> selectAllByUser(@Param("userId") Integer userId,@Param("orderStatus")Integer orderStatus);
}
