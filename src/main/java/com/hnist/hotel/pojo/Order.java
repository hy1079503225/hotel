package com.hnist.hotel.pojo;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.Date;

@Table(name = "order_hotel")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @KeySql(useGeneratedKeys = true)
    private String id;

    @Column(name = "hotel_id")
    private Integer hotelId;

    @Transient
    private String orderType;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "order_days")
    private Integer orderDays;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(name = "order_cost")
    private Double orderCost;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_username")
    private String userUsername;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_cardid")
    private String userCardid;

    public Order() {
    }
    public Order(String id,Integer orderStatus){
        this.id = id;
        this.orderStatus = orderStatus;
    }
    public Order(Integer hotelId, String roomType, Integer roomNumber, Date orderDate, Integer orderDays, Double orderCost, String userUsername, String userPhone, String userCardid, Integer orderStatus) {
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.orderDate = orderDate;
        this.orderDays = orderDays;
        this.orderCost = orderCost;
        this.userUsername = userUsername;
        this.userPhone = userPhone;
        this.userCardid = userCardid;
        this.orderStatus = orderStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderDays() {
        return orderDays;
    }

    public void setOrderDays(Integer orderDays) {
        this.orderDays = orderDays;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Double orderCost) {
        this.orderCost = orderCost;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername == null ? null : userUsername.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserCardid() {
        return userCardid;
    }

    public void setUserCardid(String userCardid) {
        this.userCardid = userCardid == null ? null : userCardid.trim();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", hotelId=" + hotelId +
                ", orderType='" + orderType + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomNumber=" + roomNumber +
                ", orderDate=" + orderDate +
                ", orderDays=" + orderDays +
                ", orderStatus=" + orderStatus +
                ", orderCost=" + orderCost +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userId=" + userId +
                ", userUsername='" + userUsername + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userCardid='" + userCardid + '\'' +
                '}';
    }
}