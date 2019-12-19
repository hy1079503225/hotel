package com.hnist.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.hnist.hotel.pojo.Hotel;
import com.hnist.hotel.service.HotelService;
import com.hnist.hotel.service.impls.HotelServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;


@Controller
@RequestMapping("hotel")
public class HotelController {
    @Resource(type = HotelService.class)
    HotelServiceImpl hotelService;

    @RequestMapping("loadhotel.do")
    @ResponseBody
    public  String loadHotel(Integer indexpage, String city,Integer userid){
        PageInfo hotelList = hotelService.queryallhotel(indexpage,city,userid);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(hotelList);
            System.out.println(s);
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("loadhotelone")
    @ResponseBody
    public String loadhotelone(Integer hotelid){
        Hotel hotel = hotelService.queryhotelone(hotelid);
        ObjectMapper objectMapper=new ObjectMapper();
        String s =null;
        try {
           s = objectMapper.writeValueAsString(hotel);
           return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping("addhotel")
    @ResponseBody
    public  String addhotel(@RequestBody Hotel hotel){
        boolean b = hotelService.inserthotel(hotel);
        if (b){
            return "true";
        }
        return "false";
    }

    @RequestMapping("deletehotel")
    @ResponseBody
    public String deletehotel(Integer hotelid,String cityname){
        boolean b = hotelService.delete(hotelid,cityname);
        if (b){
            return "true";
        }
        return "false";
    }

    @RequestMapping("updatehotel")
    @ResponseBody
    public String updatehotel(@RequestBody Map<String,Object> map){
         boolean b = hotelService.update(map);
        if (b){
            return "true";
        }
        return "false";
    }


}
