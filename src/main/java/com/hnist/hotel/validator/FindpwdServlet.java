package com.hnist.hotel.validator;

import com.hnist.hotel.pojo.User;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FindpServlet")
public class FindpwdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取用户的邮箱
        String email = request.getParameter("email");
        KafkaProperties.Admin admin = null;
        User user = null;
        PrintWriter out = response.getWriter();
        //实例化一个发送邮件的对象
        SendMail mySendMail = new SendMail();
        //根据邮箱找到该用户信息
//        admin = adminServices.getAdminByEmail(email);
//        if(admin!=null) {
//            //设置收件人和消息内容
//            mySendMail.sendMail(email, "酒店管理系统提醒，您的密码为："+admin.getPassword());
//            out.println("<script>alert('恭喜，找回密码成功');window.location.href='login.jsp'</script>");
//        } else {
//            user = userService.getUserByEmail(email);
//            if(user!=null) {
//                mySendMail.sendMail(email, "酒店管理系统提醒，您的密码为："+user.getPassword());
//                out.println("<script>alert('恭喜，找回密码成功');window.location.href='login.jsp'</script>");
//            }
//        }
//        out.println("<script>alert('该邮箱尚未注册！请重新输入');window.location.href='retrievePassword.jsp'</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
