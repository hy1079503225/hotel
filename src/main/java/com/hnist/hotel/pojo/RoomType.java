package com.hnist.hotel.pojo;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.Date;

@Table(name = "room_type")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @Column(name = "type_name")
    private String typeName;

    //床的类型
    @Column(name = "bed_type")
    private  String bedType;

    //面积
    @Column(name = "area")
    private Integer area;

    @Column(name = "num")
    private Integer num;

    @Column(name = "price")
    private Integer price;

    @Column(name = "window")
    private String window;


    @Column(name = "img_url")
    private String imgUrl;

    @Column(name="hotel_id")
    private Integer hotelId;
    @Column(name="hotel_name")
    private String hotelName;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;

    public RoomType() {
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", bedType='" + bedType + '\'' +
                ", area=" + area +
                ", num=" + num +
                ", price=" + price +
                ", window=" + window +
                ", imgUrl='" + imgUrl + '\'' +
                ", hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public RoomType(String typeName, String bedType, Integer area, Integer num, Integer price, String window, String imgUrl, Integer hotelId, String hotelName, Date createTime, Date updateTime) {
        this.typeName = typeName;
        this.bedType = bedType;
        this.area = area;
        this.num = num;
        this.price = price;
        this.window = window;
        this.imgUrl = imgUrl;
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getBedType() {
        return bedType;
    }

    public Integer getArea() {
        return area;
    }

    public Integer getNum() {
        return num;
    }

    public Integer getPrice() {
        return price;
    }

    public String getWindow() {
        return window;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
}