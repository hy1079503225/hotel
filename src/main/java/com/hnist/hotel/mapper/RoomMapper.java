package com.hnist.hotel.mapper;

import com.hnist.hotel.pojo.Room;
import com.hnist.hotel.pojo.RoomType;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Filename
 * @auther 吴星辰;
 * @data 2019/12/11 1:12;
 * @Descripion
 * @Version 1.1.1
 * @Function
 * @History
 */
public interface RoomMapper extends Mapper<Room> {

    @Select("select roomtype_id from room_roomtypr where room_id=#{roomId}")
    List<Integer> getRoomTyte(Integer roomId);
}
