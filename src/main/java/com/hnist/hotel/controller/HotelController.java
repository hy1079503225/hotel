package com.hnist.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.hnist.hotel.pojo.Hotel;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.service.HotelService;
import com.hnist.hotel.service.impls.HotelServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("hotel")
@CrossOrigin()
public class HotelController {
    @Resource(type = HotelService.class)
    HotelServiceImpl hotelService;
    @RequestMapping("loadhotel.do")
    @ResponseBody
    public  String loadHotel(Integer indexpage,String city){
        System.out.println(indexpage);
        PageInfo hotelList = hotelService.queryallhotel(indexpage,city);
        System.out.println(hotelList);
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
}
