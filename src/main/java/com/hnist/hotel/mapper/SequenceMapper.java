package com.hnist.hotel.mapper;

import com.hnist.hotel.pojo.Sequence;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SequenceMapper extends Mapper<Sequence> {

    @Select("select name, current_value, step  from sequence_info where name = #{name}")
    Sequence getSequenceByName(String name);

    @Update("update sequence_info set current_value = #{currentValue},step = #{step} where name = #{name}")
    int updateByPrimaryKeySelective(Sequence record);

}
