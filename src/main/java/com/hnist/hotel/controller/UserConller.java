package com.hnist.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.User;
import com.hnist.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("user")
@RestController
public class UserConller {

    @Autowired
    UserService userService;

    @RequestMapping("getUserList")
    @ResponseBody
    public String getUserList(@RequestParam(value="page")Integer page){
        if(page == null){
            page = 1;
        }
        //Json格式
        ObjectMapper objectMapper = new ObjectMapper();
        //分页
        PageParams pageParams = new PageParams();
        //每页大小
        pageParams.setLimit(5);
        //当前页码
        pageParams.setPage(page);
        //获取数据
        PageResult<User> pageResult= userService.getUserList(pageParams);
        pageResult.setCurrPage((long)page);

        try {
            //格式转换
            String jsonString = objectMapper.writeValueAsString(pageResult);
            System.out.println(page + "--- userPageResult ----" + jsonString + "---jsonObj--" );
            return jsonString;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
