package com.hnist.hotel.validator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.awt.geom.PathIterator;

/**
 * @Filename
 * @auther 吴星辰;
 * @data 2019/12/3 9:29;
 * @Descripion
 *  日志处理类
 *
 * @Version 1.1.1
 * @Function
 * @History
 */
@Aspect
@Component
public class LogAspect {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());


    //需要日志处理的类
    @Pointcut("execution(* com.itwcxing.web.*.*(..))")
    public void log(){}


    @Before("log()")
    public void  before(JoinPoint joinPoint){
       // System.out.println("before");
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String url=request.getRequestURI();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        System.out.println(url+ "  "+ip+"  "+classMethod);

    }

    @After("log()")
    public void after(){
       // System.out.println("after");
    }


    @AfterReturning(returning = "result",pointcut = "log()")
    public void getReturn(Object result){
        //System.out.println("return");

    }



}
