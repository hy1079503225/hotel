package com.hnist.hotel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
