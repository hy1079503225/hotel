package com.hnist.hotel.dao.impl;

import com.hnist.hotel.pojo.User;

public interface UserDao {

    public User findByUsername(String username);

    public void save(User user);

    User findByUsernameAndPassword(String username, String password);

}
