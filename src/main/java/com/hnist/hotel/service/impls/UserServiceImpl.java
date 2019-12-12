package com.hnist.hotel.service.impls;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hnist.hotel.mapper.UserMapper;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.User;
import com.hnist.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.hnist.hotel.pojo.PageParams;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public PageResult<User> getUserList(PageParams pageParams) {
        // 开始分页
        PageHelper.startPage(pageParams.getPage(), pageParams.getLimit());
        //查
        Page<User> pageInfo = (Page<User>) userMapper.selectAll();
        // 返回结果
        PageResult<User> userPageResult = new PageResult<>(pageInfo.getTotal(), pageInfo);
        //总页数
        userPageResult.setTotalPage((long) getPageNumber(pageParams.getLimit()));

        return userPageResult;
    }

    @Override
    public Integer deleteUserById(Integer userid) {
        //过滤条件
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("id",userid);

        int result = userMapper.deleteByExample(example);
        return result;
    }

    /**
     * 获得总页数
     * @param size
     * @return
     */
    public int getPageNumber(int size){
        int number = userMapper.selectCount(null);
        return number%size > 0 ? number/size+1 :number/size;
    }
}
