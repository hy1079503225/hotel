package com.hnist.hotel.mapper;

import com.hnist.hotel.pojo.Room;
import com.hnist.hotel.pojo.RoomType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    @Select("select room_type from room_type where id=#{roomId}")
    String getRoomName(Integer roomTyteId);

    @Delete("delete  from room where id=#{roomId}")
    Integer delectRoomForId(Integer roomId);

    @Update("update room set type_id=0 ,room_type='无' where type_id=#{roomTypeId}")
    Integer updateRoomTypeForBytepyId(Integer roomTypeId);

    @Select("select hole_id from user_hole where user_id =#{userId}")
    List<Integer> gethoidIds(Integer userId);
}
