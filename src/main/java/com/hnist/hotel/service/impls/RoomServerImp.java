package com.hnist.hotel.service.impls;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hnist.hotel.mapper.RoomMapper;
import com.hnist.hotel.mapper.RoomTypeMapper;
import com.hnist.hotel.pojo.*;
import com.hnist.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

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

    @Override
    public PageResult<RoomType> getAdminHotelroomTypes(PageParams pageParams, Integer userId) {
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
        Page<RoomType> pageInfo = (Page<RoomType>) roomTypeMapper.selectByExample(example);
        //System.out.println("song:" + pageInfo);
        // 返回结果
        PageResult<RoomType> roomPageResult = new PageResult<>(pageInfo.getTotal(), pageInfo);
        //总页数
        roomPageResult.setTotalPage((long) (pageInfo.getTotal()%8==0?
                pageInfo.getTotal()/pageInfo.getPageSize():pageInfo.getTotal()/pageInfo.getPageSize()+1));
        //System.out.println(roomMapper.getRoomTyte(1));

        return roomPageResult;
    }

    @Override
    public String delectAdminHotelroomType(Integer roomTypeId) {
          //更改当前类型的所有房间的类型id->0 与类型名字->无
        Integer a=roomMapper.updateRoomTypeForBytepyId(roomTypeId);
        //删除
        RoomType roomType=new RoomType();
        roomType.setId(roomTypeId);
        Integer b= roomTypeMapper.delete(roomType);
        if (a>0&&b>0){
            return "删除成功";
        }


        return "删除失败";
    }


    //未完成
    @Override
    public List<Hotel> getUserHel(Integer userId) {
        //查看这个人所有的酒店
        List<Hotel> list=new ArrayList<>();
        Hotel hotel=new Hotel();
        hotel.setId(1);
        hotel.setHotelName("test1");
        list.add(hotel);
        Hotel hotel2=new Hotel();
        hotel2.setId(2);
        hotel2.setHotelName("test2");
        list.add(hotel2);

        return list;
    }

    @Override
    public ResponseEntity addRoomType(Map<String, Object> map) {
        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){

        }
        return null;
    }

    //删除房间
    @Override
    public String delectAdminHotelroom(Integer roomId) {
        //根据房间获取类型id
        Integer typeId= roomTypeMapper.getIdforroomId(roomId);
        //该类型房间num减1
        Integer temp1=roomTypeMapper.updateNum(typeId,-1);
        //删除该房间
        Integer temp2= roomMapper.delectRoomForId(roomId);
        if (temp1>0&&temp2>0){
            return "删除成功";
        }
        return "删除失败";
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
