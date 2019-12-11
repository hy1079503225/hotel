package com.hnist.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Hello world!
 *
 */

@SpringBootApplication(scanBasePackages = {"com.hnist.hotel"})
//@RestController
@MapperScan("com.hnist.hotel.mapper")
public class App {
//
//    @Autowired
//    private UserDOMapper userDOMapper;
//
//    @RequestMapping("/")
//    public String home(){
//        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
//        if(userDO == null){
//            return "用户对象不存在";
//        }else {
//            return userDO.getName();
//        }
//    }

    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
