package com.hnist.hotel.service;

import com.github.pagehelper.PageInfo;
import com.hnist.hotel.error.BusinessException;
import com.hnist.hotel.pojo.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderService {

    Order createOrder(Integer userId,String userCardid,Integer hotel_id,String roomType,Integer roomNumber,Double order_cost) throws BusinessException;

    int addOrder(Order order);

    List<Order> getOrderList();

    Order getOrder(String orderId);

    int delete(String orderId);

    int update(Order order);

    Order selectById(String orderId);

    Order selectByNameAndPhone(String name,String phone);

    int cancelOrder(String orderId);

//    int payOrder(int orderId);

    List<Order> selectByUserId(int userId);

    PageInfo AllOrders(Integer indexpage);

    List<Order> UsersAllOrders(int userId);




}
