package com.hnist.hotel.enums;

public enum  CheckInStatus {
    WAS_CHECKIN(0,"已入住"),

    WAS_CHECKOUT(1,"已退房");

    private int code;
    private String status;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    CheckInStatus(int code,String status){
        this.code = code;
        this.status = status;
    }

}
