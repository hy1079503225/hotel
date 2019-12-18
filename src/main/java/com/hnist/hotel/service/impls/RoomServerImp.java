package com.hnist.hotel.service.impls;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hnist.hotel.mapper.HotelMapper;
import com.hnist.hotel.mapper.RoomMapper;
import com.hnist.hotel.mapper.RoomTypeMapper;
import com.hnist.hotel.mapper.UserMapper;
import com.hnist.hotel.pojo.*;
import com.hnist.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.stream.Collectors;

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
    UserMapper userMapper;
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
            List<Integer> holetIds=getUserHel(userId).stream().map(m->m.getId()).collect(Collectors.toList());
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
        //过滤条件
        Example example=new Example(Room.class);
        if (powerId==1){//超级管理员}
        }else if (powerId==2){//酒店管理员
            List<Integer> holetIds=getUserHel(userId).stream().map(m->m.getId()).collect(Collectors.toList());
            example.createCriteria().andIn("hotelId",holetIds);
        }
        // 开始分页
        PageHelper.startPage(pageParams.getPage(), pageParams.getLimit());

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




    //添加分类
    @Override
    public ResponseEntity<List<String>> addRoomType(Map<String, Object> map) {
       RoomType roomType=new RoomType();
       roomType.setArea(Integer.parseInt( map.get("area").toString()));
       roomType.setBedType( map.get("bedType").toString());
       roomType.setImgUrl((map.get("imgurl").toString()));
       roomType.setPrice( Integer.parseInt( map.get("price").toString()));
       roomType.setWindow(map.get("window").toString());
       roomType.setHotelId(Integer.parseInt( map.get("hotleId").toString()));
       roomType.setHotelName((String)map.get("hotleName").toString());
       roomType.setTypeName((String)map.get("typeName").toString());
       roomType.setNum(0);
       if (roomTypeMapper.insertSelective(roomType)>0) {
           List<String> k=new ArrayList<>();
           k.add("ok");
           return ResponseEntity.ok(k);
       }
        return null;
    }
    @Override
    public ResponseEntity<List<String>> addRoom(Map<String, Object> map) {

        Room roomType=new Room();
        roomType.setRoomNumber( map.get("roomId").toString());
        roomType.setRoomType( map.get("typeName").toString());
        roomType.setRoomImg((map.get("imgurl").toString()));
        roomType.setTypeId( Integer.parseInt( map.get("typeId").toString()));
        roomType.setHotelId(Integer.parseInt( map.get("hotleId").toString()));
        roomType.setHotelName((String)map.get("hotleName").toString());
        if (roomMapper.insertSelective(roomType)>0) {
            List<String> k=new ArrayList<>();
            k.add("ok");
            return ResponseEntity.ok(k);
        }
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> getOneRoomAndtype(Map<String, Object> map) {
        Map<String,Object> map1=new HashMap<>();
        //当前酒店的类型列表
        List<RoomType> typeList=new ArrayList<>();
        Example example=new Example(RoomType.class);
        example.createCriteria().andEqualTo("hotelId",Integer.valueOf(map.get("holeId").toString()));
        roomTypeMapper.selectByExample(example);
        ;
        map1.put("type",roomTypeMapper.selectByExample(example));
        //当前房间的信息
        map1.put("room",roomMapper.selectByPrimaryKey(map.get("roomId")));
        return ResponseEntity.ok(map1);
    }


    @Override
    public ResponseEntity<RoomType> getOneRoomType(Integer roomTypeId) {
           RoomType roomType=roomTypeMapper.selectByPrimaryKey(roomTypeId);
        return ResponseEntity.ok(roomType);
    }

    @Override
    public ResponseEntity<List<String>> updateRoomType(Map<String, Object> map) {
        RoomType roomType=new RoomType();
        roomType.setArea(Integer.parseInt( map.get("area").toString()));
        roomType.setBedType( map.get("bedType").toString());
        roomType.setImgUrl((map.get("imgurl").toString()));
        roomType.setPrice( Integer.parseInt( map.get("price").toString()));
        roomType.setWindow(map.get("window").toString());
        roomType.setTypeName((String)map.get("typeName").toString());
        roomType.setId(Integer.parseInt( map.get("id").toString()));
        if (roomTypeMapper.updateByPrimaryKeySelective(roomType)>0) {
            List<String> k=new ArrayList<>();
            k.add("ok");
            System.out.println(2);
            return ResponseEntity.ok(k);
        }
        return null;
    }


    @Override
    public ResponseEntity<List<String>> updateRoom(Map<String, Object> map) {
        Room roomType=new Room();
        roomType.setTypeId(Integer.parseInt( map.get("typeId").toString()));
        roomType.setRoomImg( map.get("imgurl").toString());
        roomType.setRoomNumber(  map.get("bianhao").toString());
        roomType.setRoomType(map.get("typeName").toString());
        roomType.setId(Integer.valueOf(map.get("roomId").toString()));
        if (roomMapper.updateByPrimaryKeySelective(roomType)>0)  {
            List<String> k=new ArrayList<>();
            k.add("ok");
            System.out.println(2);
            return ResponseEntity.ok(k);
        }
        return null;
    }

    @Override
    public ResponseEntity<List<String>> deleteroomids(String roomIds) {
        if(roomIds.toString().contains("-")) {
            List<Integer> ids=new ArrayList<>();
            String [] dis2=roomIds.toString().split("-");
            for(String s:dis2) {
                ids.add(Integer.parseInt(s));
            }
            ids.forEach(m->{ System.out.println(m);
                //根据房间获取类型id
                Integer typeId= roomTypeMapper.getIdforroomId(m);
                //该类型房间num减1
                Integer temp1=roomTypeMapper.updateNum(typeId,-1);
            });
            //类型的数量减一，对应的数
            List<String> strings=new ArrayList<>();
            strings.add("ok");
            if (roomMapper.deleteByPrimaryKey(ids)>0)
                return  ResponseEntity.ok(strings);
            return null;
        }else {
           return null;
        }

    }

    @Override
    public ResponseEntity<List<String>> deleteroomtypeids(String roomIds) {
        if(roomIds.toString().contains("-")) {
            List<Integer> ids=new ArrayList<>();
            String [] dis2=roomIds.toString().split("-");
            for(String s:dis2) {
                ids.add(Integer.parseInt(s));
            }
            ids.forEach(m-> {
                System.out.println(m);
                Integer a=roomMapper.updateRoomTypeForBytepyId(m);

            });
            List<String> strings=new ArrayList<>();
            strings.add("ok");
            //改房间的类型为id为0 type为空


            if (roomTypeMapper.deleteByPrimaryKey(ids)>0)
                return  ResponseEntity.ok(strings);
            return null;
        }else {
            return null;
        }
    }

    @Override
    public List<RoomType> getUserHoteltyoes(Integer hotleId) {
        RoomType roomType=new RoomType() ;
        roomType.setHotelId(hotleId);
        return roomTypeMapper.select(roomType);

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




//    private List<Integer> getHoletIds(Integer userId) {
//        System.out.println("获取到拥有的酒店的信息");
//        List<Integer> holtids=new ArrayList<>();
//        holtids.add(1);
//        return holtids;
//    }


    @Autowired
    HotelMapper hotelMapper;
    //这个人所有的酒店 未完成Override
    public List<Hotel> getUserHel(Integer userId) {
        //查看这个人所有的酒店
        List<Hotel> list=new ArrayList<>();

        List<Integer> holtId= roomMapper.gethoidIds(userId);
        holtId.forEach(m->{
            Example example=new Example(Hotel.class);
            example.createCriteria().andEqualTo("id",m);
//            Hotel hotel =);
            list.add(hotelMapper.selectOneByExample(example));
        });
        list.forEach(m->{
            System.out.println(m);
        });
//        Hotel hotel=new Hotel();
//        hotel.setId(1);
//        hotel.setHotelName("test1");
//        list.add(hotel);
//        Hotel hotel2=new Hotel();
//        hotel2.setId(3);
//        hotel2.setHotelName("test2");
//        list.add(hotel2);

        return list;
    }
    //获取权限（未完成）
    public Integer getPower(Integer userId){
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("id",userId);
       User user= userMapper.selectOneByExample(example);
        return user.getType();

    }


}
