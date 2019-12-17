package com.hnist.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.User;
import com.hnist.hotel.service.UserService;
import com.sun.xml.internal.ws.util.ByteArrayDataSource;
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
     *
     */
    @PostMapping("queryUserById")
    public String queryUserById(HttpServletRequest request){
        //用户id，留做权限判断
        String useridStr = request.getParameter("userid");
        if (useridStr!=null||Integer.valueOf(useridStr)!=3){
//            return "无操作权限";
        }

        String idStr = request.getParameter("id");
        if (idStr==null){
            return "false";
        }
        Integer id = Integer.valueOf(idStr);
        User user = userService.queryUserById(id);
        //Json格式
        String json = JSON.toJSONString(user);

        return user==null?"false":json;
    }
    /**
     * 获取用户列表
     * @param request
     * @return
     */
    @PostMapping("getUserList")
    public String getUserList(HttpServletRequest request){
        //用户id，留做权限判断
        String useridStr = request.getParameter("userid");
        if (useridStr==null||Integer.valueOf(useridStr)!=3){
//            return "无操作权限";
        }

        //搜索条件
        String search = request.getParameter("search");
        if (search == null ){
            search = "";
        }

        //只查看已冻结用户
        String search1 = request.getParameter("search1");
        if (search1 == null ){
            search1 = "0";
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
        PageResult<User> pageResult= userService.getUserList(pageParams,search,search1);
        pageResult.setCurrPage((long)page);

        try {
            //格式转换
            String jsonString = objectMapper.writeValueAsString(pageResult);
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
        if (useridStr==null||Integer.valueOf(useridStr)!=3){
//            return "无操作权限";
        }

        Integer id = Integer.valueOf(request.getParameter("id"));
        if(id==null) return null;
        return userService.deleteUserById(id)>0
                ? "true" : "false";
    }

    /**
     * 1、修改用户信息
     * 2、根据id锁定或用户
     * @param request
     * @return
     */
    @RequestMapping("updateUserById")
    @ResponseBody
    public String updateUserById(HttpServletRequest request){
        //用户id，留做权限判断
        String useridStr = request.getParameter("userid");
        if (useridStr == null||Integer.valueOf(useridStr)!=3){
//            return "无操作权限";
        }
        //获取request中数据
        User user = getUserInfo(request);
        if (user == null) return "false";

        return userService.updateUserById(user)>0
                ? "true" : "false";
    }
    /**
     * 1、新增用户
     * @param request
     * @return
     */
    @RequestMapping("addUserById")
    @ResponseBody
    public String addUserById(HttpServletRequest request){
        //用户id，留做权限判断
        String useridStr = request.getParameter("userid");
        if (useridStr == null||Integer.valueOf(useridStr)!=3){
//            return "无操作权限";
        }
        //获取request中数据
        User user = getUserInfo(request);
        if (user == null) return "false";

        return userService.addUser(user)
                ? "true" : "false";
    }

    //获取用户信息
    public User getUserInfo(HttpServletRequest request){
        //获取前端传来数据
        String idStr = request.getParameter("id");
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String genderInt = request.getParameter("genderInt");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String cardId = request.getParameter("cardId");
        String password = request.getParameter("password");
        String statusStr = request.getParameter("status");

        User user = new User();
        //判空
        if(idStr==null){
            return null;
        }else {
            user.setId(Integer.valueOf(idStr));
        }
        if(username!=null){
            user.setUsername(username);
        }
        if(name!=null){
            user.setName(name);
        }
        if(genderInt!=null){
            user.setGender(Byte.valueOf(genderInt));
        }
        if(phone!=null){
            user.setPhone(phone);
        }
        if(email!=null){
            user.setEmail(email);
        }
        if(address!=null){
            user.setAddress(address);
        }
        if(cardId!=null){
            user.setCardId(cardId);
        }
        if(password!=null){
            user.setPassword(password);
        }
        if(statusStr!=null){
            user.setStatus(Integer.valueOf(statusStr));
        }

        return user;
    }
}
