package com.hnist.hotel;

import com.hnist.hotel.dao.UserDOMapper;
import com.hnist.hotel.pojo.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication(scanBasePackages = {"com.hnist.hotel"})
@RestController
@MapperScan("com.hnist.hotel.dao")
public class App {

    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public String home(){
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if(userDO == null){
            return "用户对象不存在";
        }else {
            return userDO.getName();
        }
    }

    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
