package com.hnist.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.hnist.hotel.enums.OrderStatus;
import com.hnist.hotel.pojo.Order;
import com.hnist.hotel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller("order")
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest httpServletRequest;

//    @RequestMapping(value = "createorder")
//    @ResponseBody
//    public CommonReturnType createOrder(Integer hotel_id, String roomType, Integer roomNumber, Integer num, Double order_cost) throws BusinessException {
//        Boolean isLogin = (Boolean) httpServletRequest.getSession().getAttribute("IS_LOGIN");
//        if (isLogin == null || !isLogin.booleanValue()){
////            throw new BusinessException(EmBusinessError.USER_NOT_LOGIN,"用户还未登录，不能下单！");
//            System.out.println("111");
//        }
//        User user = (User) httpServletRequest.getSession().getAttribute("LOGIN_USER");
//        Order order = orderService.createOrder(user.getId(), user.getCardId(), hotel_id, roomType, roomNumber, num, order_cost);
//        return CommonReturnType.create(null);
//    }

//    @RequestMapping("input")
//    @ResponseBody
//    public CommonReturnType inputOrder(){
//        return null;
//    }

    @RequestMapping("add")
    public int addOrder(Integer hotelId,String name, String phone, String cardId,Integer roomNumber,Integer roomTypeId, String roomType,
                        @DateTimeFormat(pattern = "yyyy-MM-dd")Date orderDate,Integer orderDays,Double orderCost){
        Order order = new Order(hotelId,roomType,roomNumber,orderDate,orderDays,orderCost,name,phone,cardId, OrderStatus.UNPAY.getCode());
        return orderService.addOrder(order);
    }

    /**
     * 管理员删除订单
     * @param orderId
     * @return
     */
    @RequestMapping("delete")
    public int deleteOrder(String orderId){
        return orderService.delete(orderId);
    }

    @RequestMapping("deleteByUser")
    public int deleteOrderByUser(String orderId){
        Order order = new Order(orderId,OrderStatus.WAS_DELETED.getCode());
        return orderService.update(order);
    }

    @RequestMapping("cancel")
    public int cancelOrder(String orderId){
        return orderService.cancelOrder(orderId);
    }

    @RequestMapping("overtime")
    public int orderOver(String orderId){
        Order order = new Order(orderId,OrderStatus.OVERTIME.getCode());
        return orderService.update(order);
    }

    @RequestMapping("all")
    @ResponseBody
    public String  getAllOrder(Integer indexpage){
        System.out.println(indexpage);
        PageInfo pageInfo = orderService.AllOrders(indexpage);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            String string = objectMapper.writeValueAsString(pageInfo);
            System.out.println(string);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据userId查询所有订单
     * @param userId
     * @return
     */
    @RequestMapping("byuserid")
    public List<Order> getByUser(int userId){
        return orderService.selectByUserId(userId);
    }

    /**
     * 根据订单号查询订单
     * @param orderId
     * @return
     */
    @RequestMapping("byorderid")
    public Order getById(String orderId){
        return orderService.selectById(orderId);
    }

    @RequestMapping("bynameandphone")
    public Order getByNameAndPhone(String name,String phone){
        return orderService.selectByNameAndPhone(name,phone);
    }
}
