package com.hnist.hotel.pojo;

import java.util.Date;

public class CheckIn {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.user_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.user_name
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.order_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.hotel_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Integer hotelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.hotel_name
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private String hotelName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.room_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Integer roomId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.room_number
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private String roomNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.room_type
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private String roomType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.person_number
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Integer personNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.card_ids
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private String cardIds;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.check_in_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Date checkInTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.chek_out_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Date chekOutTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.create_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.update_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.id
     *
     * @return the value of check_in.id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.id
     *
     * @param id the value for check_in.id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.user_id
     *
     * @return the value of check_in.user_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.user_id
     *
     * @param userId the value for check_in.user_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.user_name
     *
     * @return the value of check_in.user_name
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.user_name
     *
     * @param userName the value for check_in.user_name
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.order_id
     *
     * @return the value of check_in.order_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.order_id
     *
     * @param orderId the value for check_in.order_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.hotel_id
     *
     * @return the value of check_in.hotel_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Integer getHotelId() {
        return hotelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.hotel_id
     *
     * @param hotelId the value for check_in.hotel_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.hotel_name
     *
     * @return the value of check_in.hotel_name
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.hotel_name
     *
     * @param hotelName the value for check_in.hotel_name
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.room_id
     *
     * @return the value of check_in.room_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.room_id
     *
     * @param roomId the value for check_in.room_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.room_number
     *
     * @return the value of check_in.room_number
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.room_number
     *
     * @param roomNumber the value for check_in.room_number
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber == null ? null : roomNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.room_type
     *
     * @return the value of check_in.room_type
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.room_type
     *
     * @param roomType the value for check_in.room_type
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.person_number
     *
     * @return the value of check_in.person_number
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Integer getPersonNumber() {
        return personNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.person_number
     *
     * @param personNumber the value for check_in.person_number
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.card_ids
     *
     * @return the value of check_in.card_ids
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public String getCardIds() {
        return cardIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.card_ids
     *
     * @param cardIds the value for check_in.card_ids
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setCardIds(String cardIds) {
        this.cardIds = cardIds == null ? null : cardIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.check_in_time
     *
     * @return the value of check_in.check_in_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Date getCheckInTime() {
        return checkInTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.check_in_time
     *
     * @param checkInTime the value for check_in.check_in_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.chek_out_time
     *
     * @return the value of check_in.chek_out_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Date getChekOutTime() {
        return chekOutTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.chek_out_time
     *
     * @param chekOutTime the value for check_in.chek_out_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setChekOutTime(Date chekOutTime) {
        this.chekOutTime = chekOutTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.create_time
     *
     * @return the value of check_in.create_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.create_time
     *
     * @param createTime the value for check_in.create_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.update_time
     *
     * @return the value of check_in.update_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.update_time
     *
     * @param updateTime the value for check_in.update_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}