package com.hnist.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.User;
import com.hnist.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther Cheirmin;
 */

@RequestMapping("user")
@RestController
public class UserConller {

    @Autowired
    UserService userService;

    /**
     * 获取用户列表
     * @param request
     * @return
     */
    @PostMapping("getUserList")
    public String getUserList(HttpServletRequest request){
        //用户id，留做权限判断
        String useridStr = request.getParameter("userid");
        if (useridStr!=null||Integer.valueOf(useridStr)!=3){
//            return "无操作权限";
        }
        //搜索条件
        String search = request.getParameter("search");
        if (search == null ){
            search = "";
        }else {
            request.setAttribute("search",search);
        }

        //当前页
        Integer page = Integer.valueOf(request.getParameter("currentpage"));
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
        PageResult<User> pageResult= userService.getUserList(pageParams,search);
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

    /**
     * 根据id删除用户
     * @param request
     * @return
     */
    @RequestMapping("deleteUserById")
    @ResponseBody
    public String deleteUserById(HttpServletRequest request){
        //用户id，留做权限判断
        String useridStr = request.getParameter("userid");
        if (useridStr!=null||Integer.valueOf(useridStr)!=3){
//            return "无操作权限";
        }

        Integer id = Integer.valueOf(request.getParameter("id"));
        if(id==null) return null;
        return userService.deleteUserById(id)>0
                ? "true" : "false";
    }

    /**
     * 根据id锁定或用户
     * @param request
     * @return
     */
    @RequestMapping("updateUserById")
    @ResponseBody
    public String updateUserById(HttpServletRequest request){
        //用户id，留做权限判断
        String useridStr = request.getParameter("userid");
        if (useridStr!=null||Integer.valueOf(useridStr)!=3){
//            return "无操作权限";
        }

        //获取前端传来数据
        String idStr = request.getParameter("id");
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String genderStr = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String card_id = request.getParameter("card_id");
        String password = request.getParameter("password");
        String statusStr = request.getParameter("status");

        User user = new User();
        //判空
        if(idStr==null){
            return "false";
        }else {
            user.setId(Integer.valueOf(idStr));
        }
        if(username!=null){

        }
        if(name!=null){

        }
        if(genderStr!=null){

        }
        if(phone!=null){

        }
        if(email!=null){

        }
        if(address!=null){

        }
        if(card_id!=null){

        }
        if(password!=null){

        }
        if(statusStr!=null){
            user.setStatus(Integer.valueOf(statusStr));
        }
        return userService.updateUserById(user)>0
                ? "true" : "false";
    }
}
