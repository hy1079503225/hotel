package com.hnist.hotel.service.impls;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnist.hotel.enums.OrderStatus;
import com.hnist.hotel.error.BusinessException;
import com.hnist.hotel.error.EmBusinessError;
import com.hnist.hotel.mapper.OrderMapper;
import com.hnist.hotel.mapper.SequenceMapper;
import com.hnist.hotel.pojo.Order;
import com.hnist.hotel.pojo.Sequence;
import com.hnist.hotel.service.OrderService;
import com.hnist.hotel.service.RoomService;

import com.hnist.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private RoomService roomService;

//    @Autowired
//    private RoomTypeService roomTypeService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private SequenceMapper sequenceMapper;

    @Override
    @Transactional
    public Order createOrder(Integer userId,String userCardid,Integer hotel_id,String roomType,Integer roomNumber,Double order_cost){

        //订单入库
        Order order = new Order();
        order.setHotelId(hotel_id);
        order.setUserId(userId);
        order.setUserCardid(userCardid);
        order.setRoomType(roomType);
        order.setRoomNumber(roomNumber);
        order.setOrderCost(order_cost);

        //生成订单号
        order.setId(generateOrderNo());
        orderMapper.addOrder(order);
        return order;
    }

    @Override
    public int addOrder(Order order) {
        return orderMapper.insertSelective(order);
    }

    @Override
    public Order getOrder(String orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        return order;
    }

    @Override
    public int delete(String orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int update(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Order selectById(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public Order selectByNameAndPhone(String name, String phone) {
        Order order = new Order();
        order.setUserUsername(name);
        order.setUserPhone(phone);
        order.setOrderStatus(OrderStatus.PAY.getCode());
        return orderMapper.selectByNameAndPhone(order);
    }

    @Override
    public int cancelOrder(String orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null){
            return -3;
        }else {
            order.setOrderStatus(OrderStatus.WAS_CANCELED.getCode());
        }
//        if (roomTypeService)
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public List<Order> selectByUserId(int userId) {
        return orderMapper.selectByUserId(userId);
    }

    @Override
    public PageInfo AllOrders(Integer indexpage) {
        if (indexpage==null){
            indexpage=1;
        }
        PageHelper.startPage(indexpage,3);
        List<Order> orderList = orderMapper.selectAll();
        PageInfo pageInfo=new PageInfo(orderList);
        return pageInfo;
    }

    @Override
    public List<Order> UsersAllOrders(int userId) {
        return orderMapper.selectAllByUser(userId,OrderStatus.WAS_DELETED.getCode());
    }

    @Override
    public List<Order> getOrderList() {
        List<Order> orders = orderMapper.selectAll();
        return orders;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String generateOrderNo(){
        //订单号有16位
        StringBuilder stringBuilder = new StringBuilder();
        //前八位为时间信息,年月日

        //获取当前时间
        java.time.LocalDateTime now = LocalDateTime.now();
        String nowDate = now.format(DateTimeFormatter.ISO_DATE).replace("-", "");
        stringBuilder.append(nowDate);

        //中间6位为自增序列
        //获取当前sequence
        int s = 0;
        Sequence sequence = sequenceMapper.getSequenceByName("order");
        s = sequence.getCurrentValue();
        sequence.setCurrentValue(sequence.getCurrentValue() + sequence.getStep());
        sequenceMapper.updateByPrimaryKeySelective(sequence);
        String sequenceStr = String.valueOf(sequence);
        for (int i = 0; i < 6 - sequenceStr.length(); i++) {
            stringBuilder.append(0);
        }
        stringBuilder.append(sequenceStr);

        //最后2位为分库分表位,暂时写死
        stringBuilder.append("00");
        return stringBuilder.toString();
    }
}
