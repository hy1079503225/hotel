package com.hnist.hotel.service;

import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.User;

import java.util.Map;

public interface UserService {
    PageResult<User> getUserList(PageParams pageParams,String search,String search1);
    Integer deleteUserById(Integer userid);
    Integer updateUserById(User user);
    User queryUserById(Integer id);
    Boolean addUser(User user);

    Map<String,String> login(Map<String, String> map);

    Map<String, String> adminlogin(Map<String, String> map);

    User getUserbyUsername(String userName);
}
