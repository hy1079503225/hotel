package com.hnist.hotel.pojo;

import java.util.Date;

public class Order {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.hotel_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Integer hotelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.order_type
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private String orderType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.room_type
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private String roomType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.room_number
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Integer roomNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.order_date
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Date orderDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.order_days
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Integer orderDays;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.order_status
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Integer orderStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.order_cost
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Double orderCost;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.create_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.update_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.user_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.user_username
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private String userUsername;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.user_phone
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private String userPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.user_cardid
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private String userCardid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.id
     *
     * @return the value of order.id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.id
     *
     * @param id the value for order.id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.hotel_id
     *
     * @return the value of order.hotel_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Integer getHotelId() {
        return hotelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.hotel_id
     *
     * @param hotelId the value for order.hotel_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.order_type
     *
     * @return the value of order.order_type
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.order_type
     *
     * @param orderType the value for order.order_type
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.room_type
     *
     * @return the value of order.room_type
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.room_type
     *
     * @param roomType the value for order.room_type
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.room_number
     *
     * @return the value of order.room_number
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Integer getRoomNumber() {
        return roomNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.room_number
     *
     * @param roomNumber the value for order.room_number
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.order_date
     *
     * @return the value of order.order_date
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.order_date
     *
     * @param orderDate the value for order.order_date
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.order_days
     *
     * @return the value of order.order_days
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Integer getOrderDays() {
        return orderDays;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.order_days
     *
     * @param orderDays the value for order.order_days
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setOrderDays(Integer orderDays) {
        this.orderDays = orderDays;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.order_status
     *
     * @return the value of order.order_status
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.order_status
     *
     * @param orderStatus the value for order.order_status
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.order_cost
     *
     * @return the value of order.order_cost
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Double getOrderCost() {
        return orderCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.order_cost
     *
     * @param orderCost the value for order.order_cost
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setOrderCost(Double orderCost) {
        this.orderCost = orderCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.create_time
     *
     * @return the value of order.create_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.create_time
     *
     * @param createTime the value for order.create_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.update_time
     *
     * @return the value of order.update_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.update_time
     *
     * @param updateTime the value for order.update_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.user_id
     *
     * @return the value of order.user_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.user_id
     *
     * @param userId the value for order.user_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.user_username
     *
     * @return the value of order.user_username
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public String getUserUsername() {
        return userUsername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.user_username
     *
     * @param userUsername the value for order.user_username
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername == null ? null : userUsername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.user_phone
     *
     * @return the value of order.user_phone
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.user_phone
     *
     * @param userPhone the value for order.user_phone
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.user_cardid
     *
     * @return the value of order.user_cardid
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public String getUserCardid() {
        return userCardid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.user_cardid
     *
     * @param userCardid the value for order.user_cardid
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setUserCardid(String userCardid) {
        this.userCardid = userCardid == null ? null : userCardid.trim();
    }
}