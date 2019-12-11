package com.hnist.hotel.service;

import com.hnist.hotel.pojo.PageParams;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.User;
import org.springframework.stereotype.Service;

public interface UserService {
    PageResult<User> getUserList(PageParams pageParams);
}
