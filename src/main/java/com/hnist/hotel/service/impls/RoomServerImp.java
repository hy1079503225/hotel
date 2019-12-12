package com.hnist.hotel.service.impls;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hnist.hotel.mapper.RoomMapper;
import com.hnist.hotel.mapper.RoomTypeMapper;
import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.Room;
import com.hnist.hotel.pojo.RoomType;
import com.hnist.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    RoomTypeMapper roomTypeMapper;


    @Override
    public PageResult<RoomType> getRoomTypeList(PageParams pageParams, Integer hotelId) {
        System.out.println("sss");
        // 开始分页
        PageHelper.startPage(pageParams.getPage(), pageParams.getLimit());
        //过滤条件
        Example example=new Example(RoomType.class);

        example.createCriteria().andEqualTo("hotelId",hotelId);
        //查询
        Page<RoomType> pageInfo = (Page<RoomType>) roomTypeMapper.selectByExample(example);
        //System.out.println("song:" + pageInfo);
        // 返回结果

        PageResult<RoomType> roomPageResult = new PageResult<>(pageInfo.getTotal(), pageInfo);
        //总页数
        roomPageResult.setTotalPage((long) (pageInfo.getTotal()%5==0?
        pageInfo.getTotal()/pageInfo.getPageSize():pageInfo.getTotal()/pageInfo.getPageSize()+1));
        return roomPageResult;

    }

    @Override
    public PageResult<Room> getAdminRoomList(PageParams pageParams, Integer userId) {
        Integer powerId= getPower(userId);

            // 开始分页
            PageHelper.startPage(pageParams.getPage(), pageParams.getLimit());
            //过滤条件
            Example example=new Example(Room.class);
        if (powerId==1){//超级管理员}


        }else if (powerId==2){//酒店管理员
            List<Integer> holetIds=getHoletIds(userId);
            example.createCriteria().andIn("hotelId",holetIds);
        }
            //查询
            Page<Room> pageInfo = (Page<Room>) roomMapper.selectByExample(example);
            //System.out.println("song:" + pageInfo);
            // 返回结果
            PageResult<Room> roomPageResult = new PageResult<>(pageInfo.getTotal(), pageInfo);
            //总页数
            roomPageResult.setTotalPage((long) (pageInfo.getTotal()%8==0?
                    pageInfo.getTotal()/pageInfo.getPageSize():pageInfo.getTotal()/pageInfo.getPageSize()+1));
            //System.out.println(roomMapper.getRoomTyte(1));

            return roomPageResult;

    }

    private List<Integer> getHoletIds(Integer userId) {
        System.out.println("获取到拥有的酒店的信息");
        List<Integer> holtids=new ArrayList<>();
        holtids.add(1);
        return holtids;
    }


    //获取权限（未完成）
    public Integer getPower(Integer userId){
        System.out.println("获取权限");
        return 2;

    }


}
