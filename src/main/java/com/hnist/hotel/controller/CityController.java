package com.hnist.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.hnist.hotel.pojo.City;
import com.hnist.hotel.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("city")
public class CityController {

    @Resource(type = CityService.class)
    CityService cityService;

    @RequestMapping("loadcity")
    @ResponseBody
    public String loadcity(Integer indexpage){
        System.out.println("-----------city");
        PageInfo queryallcity = cityService.queryallcity(indexpage);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(queryallcity);
            System.out.println(s);
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("showcity")
    @ResponseBody
    public String showcity(){
        List<City> cities = cityService.queryshowcity();
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(cities);
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("addcity")
    @ResponseBody
    public String addcity(City city){
        boolean b = cityService.addcity(city);
        if (b){
            return "true";
        }
        return "false";
    }

    @RequestMapping("deletecity")
    @ResponseBody
    public String deletcity(Integer id){
        boolean b = cityService.deleteCity(id);
        if (b){
            return "true";
        }
        return "false";
    }

    @RequestMapping("updatecity")
    @ResponseBody
    public String updatecity(@RequestBody City city){
        boolean b = cityService.updateCity(city);
        if (b){
            return "true";
        }
        return "false";
    }
}
