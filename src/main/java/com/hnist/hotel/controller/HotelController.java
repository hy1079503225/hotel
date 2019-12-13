package com.hnist.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.hnist.hotel.pojo.Hotel;
import com.hnist.hotel.service.HotelService;
import com.hnist.hotel.service.impls.HotelServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;


@Controller
@RequestMapping("hotel")
public class HotelController {
    @Resource(type = HotelService.class)
    HotelServiceImpl hotelService;
    @RequestMapping("loadhotel.do")
    @ResponseBody
    public  String loadHotel(Integer indexpage, String city){
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

    @RequestMapping("loadhotelone")
    @ResponseBody
    public String loadhotelone(Integer hotelid){
        hotelid=1;
        Hotel hotel = hotelService.queryhotelone(hotelid);
        ObjectMapper objectMapper=new ObjectMapper();
        String s =null;
        try {
           s = objectMapper.writeValueAsString(hotel);
            System.out.println(s);
           return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping("addhotel")
    public  String addhotel(HttpServletRequest request,Hotel hotel, @RequestParam("picture") MultipartFile file){
//        获取工程路径
        String realpath=request.getServletContext().getRealPath("/");
//        设置上传文件的路径
        realpath+="before/hotel";
        String picturename = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        long time = new Date().getTime();
        String s = Long.toHexString(time);
        hotel.setHotelImg(s+picturename);
        try {
            file.transferTo(new File(realpath+s+picturename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean b = hotelService.inserthotel(hotel);
        if (b){
            return "hotellist.html";
        }
        return "false";
    }

    @RequestMapping("deletehotel")
    public String deletehotel(Integer hotelid){
        boolean b = hotelService.delete(hotelid);
        if (b){
            return "true";
        }
        return "false";
    }

    @RequestMapping("updatehotel")
    public String updatehotel(Hotel hotel){
        boolean b = hotelService.update(hotel);
        if (b){
            return "loadhotel.do";
        }
        return "false";
    }
}
