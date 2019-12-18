package com.hnist.hotel.validator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.User;
import com.hnist.hotel.service.UserService;
import com.hnist.hotel.service.impls.UserServiceImpl;
import org.springframework.beans.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/registUserServlet")
public class RegistUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //验证校验
        String otpCode = request.getParameter("otpCode");
        HttpSession session = request.getSession();

        //获取数据
        Map<String,String[]> map = request.getParameterMap();
        //封装对象
        User user = new User();
//        BeanUtils.populate(user,map);

        //调用service完成注册
        UserService service = new UserServiceImpl();
        boolean flag = service.regist(user);

        PageResult result = new PageResult();

        //响应结果
        if (flag){
            //注册成功
            result.setFlag(true);

        }else {
            //注册失败
            result.setFlag(false);
            result.setErrorMsg("注册失败！");

        }

        //将result对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        //将json数据写回客户端
        //设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
