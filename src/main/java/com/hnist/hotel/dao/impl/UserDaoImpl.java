package com.hnist.hotel.dao.impl;

import com.hnist.hotel.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao{

    private JdbcTemplate template = new JdbcTemplate();

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            //定义user
            String sql = "select * from user where username=?";
            //执行user
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        }catch (Exception e){
        }
        return user;
    }

    /**
     * 根据用户名和密码查询的方法
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String username,String password) {

        User user = null;
        try {
            //定义user
            String sql = "select * from tb_user where username = ?";
            //执行user
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        }catch (Exception e){

        }
        return user;
    }

    @Override
    public void save(User user) {
        String sql = "insert into user(telphone,otpCode,name,password,gender,age)+" +
                "values(?,?,?,?,?,?)";
        template.update(sql,user.getPhone(),user.getAddress(),
                user.getCardId(),
                user.getCreateTime(),
                user.getEmail(),
                user.getGender(),
                user.getId()
        );
    }
}
