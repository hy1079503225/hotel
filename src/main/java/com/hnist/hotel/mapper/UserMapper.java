package com.hnist.hotel.mapper;

import com.github.pagehelper.Page;
import com.hnist.hotel.pojo.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

/**
 * @Filename
 * @auther Cheirmin;
 * @data 2019/12/11 1:12;
 * @Descripion
 * @Version 1.1.1
 * @Function
 * @History
 */
public interface UserMapper extends Mapper<User> {
}
