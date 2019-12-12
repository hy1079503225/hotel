package com.hnist.hotel.pojo;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name="room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @Column(name="hotel_id")
    private Integer hotelId;

    @Column(name="state")
    private Integer state;
    @Column(name="hotel_name")
    private String hotelName;
    //房间号码
    @Column(name="room_id")
    private String roomNumber;


  @Column(name = "type_id")
   private Integer typeId;
    @Column(name = "room_type")
    private String roomType;
@Column(name="room_img")
    private String roomImg;
    @Column(name="create_time")
    private Date createTime;
    @Column(name="update_time")
    private Date updateTime;

    public void setState(Integer state) {
        this.state = state;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getState() {
        return state;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public String getRoomType() {
        return roomType;
    }
//    private Integer typeId;
//    private String roomType;
   // private Double roomPrice;
    //折扣
  //  private Double roomDiscount;
    //房间状态
   // private Byte roomStatus;




    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getHotelId() {
        return hotelId;
    }


    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.hotel_name
     *
     * @return the value of room.hotel_name
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.hotel_name
     *
     * @param hotelName the value for room.hotel_name
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.room_number
     *
     * @return the value of room.room_number
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.room_number
     *
     * @param roomNumber the value for room.room_number
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber == null ? null : roomNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.type_id
     *
     * @return the value of room.type_id
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.room_type
     *
     * @return the value of room.room_type
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */


    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.room_type
     *
     * @param roomType the value for room.room_type
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */





    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.remark
     *
     * @return the value of room.remark
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.room_img
     *
     * @return the value of room.room_img
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public String getRoomImg() {
        return roomImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.room_img
     *
     * @param roomImg the value for room.room_img
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setRoomImg(String roomImg) {
        this.roomImg = roomImg == null ? null : roomImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.create_time
     *
     * @return the value of room.create_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.create_time
     *
     * @param createTime the value for room.create_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.update_time
     *
     * @return the value of room.update_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.update_time
     *
     * @param updateTime the value for room.update_time
     *
     * @mbg.generated Tue Dec 10 21:40:46 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}