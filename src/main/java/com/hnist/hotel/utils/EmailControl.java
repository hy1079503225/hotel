package com.hnist.hotel.utils;

import com.hnist.hotel.service.MalUtiliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @Filename
 * @auther 吴星辰;
 * @data 2019/12/5 11:45;
 * @Descripion
 * @Version 1.1.1
 * @Function
 * @History
 */


@Controller
public class EmailControl {

    @Autowired
private MalUtiliService malUtiliService;

    @RequestMapping("getCheckCode")
    @ResponseBody
    public String getCheckCode(String email){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的验证码为："+checkCode;
        try {
            malUtiliService.sendSimpleMail(email, "你在注册验证码为:", message);
        }catch (Exception e){
            return "";
        }
        return checkCode;
    }
}
