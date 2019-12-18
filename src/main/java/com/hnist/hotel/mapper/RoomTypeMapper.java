package com.hnist.hotel.mapper;

import com.hnist.hotel.pojo.RoomType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Filename
 * @auther 吴星辰;
 * @data 2019/12/11 21:10;
 * @Descripion
 * @Version 1.1.1
 * @Function
 * @History
 */
public interface RoomTypeMapper extends Mapper<RoomType> {

    @Select("select type_id from room where id=#{roomId}")
    Integer getIdforroomId(Integer roomId);

    @Update("update room_type set num=num+#{i} where id=#{typeId}")
    Integer updateNum(Integer typeId, int i);



}
