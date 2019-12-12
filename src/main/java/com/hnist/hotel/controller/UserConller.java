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
        Integer userid = Integer.valueOf(request.getParameter("userid"));
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

    /**
     * 根据id删除用户
     * @param request
     * @return
     */
    @RequestMapping("deleteUserById")
    @ResponseBody
    public String deleteUserById(HttpServletRequest request){
        //用户id，留做权限判断
        Integer userid = Integer.valueOf(request.getParameter("userid"));

        Integer id = Integer.valueOf(request.getParameter("id"));
        if(id==null) return null;
        return userService.deleteUserById(id)>0
                ? "true" : "false";
    }

    /**
     * 修改用户信息，还没写
     * @param userid
     * @param user
     * @return
     */
    public String updateUserById(@RequestParam(value="userid")Integer userid,User user){
        if(userid==null) return null;

        return userService.updateUserById(userid,user)>0
                ? "true" : "false";
    }
}
