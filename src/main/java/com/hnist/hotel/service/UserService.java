package com.hnist.hotel.service;

import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.User;

public interface UserService {
    PageResult<User> getUserList(PageParams pageParams);
    Integer deleteUserById(Integer userid);
    Integer updateUserById(User user);
}
