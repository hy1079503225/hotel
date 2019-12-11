package com.hnist.hotel.service.impls;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hnist.hotel.mapper.RoomMapper;
import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.Room;
import com.hnist.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Filename
 * @auther 吴星辰;
 * @data 2019/12/11 0:44;
 * @Descripion
 * @Version 1.1.1
 * @Function
 * @History
 */
@Service
public class RoomServerImp implements RoomService {

    @Autowired
    RoomMapper roomMapper;


    @Override
    public PageResult<Room> getRoomList(PageParams pageParams, Integer hotelId) {
        // 开始分页
        PageHelper.startPage(pageParams.getPage(), pageParams.getLimit());
        //过滤条件
        Example example=new Example(Room.class);

        example.createCriteria().andEqualTo("hotelId",hotelId);
        //查询
        Page<Room> pageInfo = (Page<Room>) roomMapper.selectByExample(example);
        //System.out.println("song:" + pageInfo);
        // 返回结果
        PageResult<Room> roomPageResult = new PageResult<>(pageInfo.getTotal(), pageInfo);
        //总页数
        roomPageResult.setTotalPage((long) getPageNumber(pageParams.getLimit()));
        return roomPageResult;


    }
    /**
     * 获得总页数
     * @param size
     * @return
     */
    public int getPageNumber(int size){
        int number = roomMapper.selectCount(null);
        return number%size > 0 ? number/size+1 :number/size;
    }

}
