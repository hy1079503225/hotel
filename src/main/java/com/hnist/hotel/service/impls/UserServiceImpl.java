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

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public PageResult<User> getUserList(PageParams pageParams,String search) {
        search = "%" + search + "%";
        // 开始分页
        PageHelper.startPage(pageParams.getPage(), pageParams.getLimit());
        //查询条件，用户名，电话，身份证号码
        Example example=new Example(User.class);
        example.createCriteria().andLike("username",search);
        example.or(example.createCriteria().andLike("phone",search));
        example.or(example.createCriteria().andLike("cardId",search));
        //查
        Page<User> pageInfo = (Page<User>) userMapper.selectByExample(example);
        // 返回结果
        PageResult<User> userPageResult = new PageResult<>(pageInfo.getTotal(), pageInfo);
        //总页数
        userPageResult.setTotalPage((long) getPageNumber(pageParams.getLimit()));

        return userPageResult;
    }

    @Override
    public Integer deleteUserById(Integer id) {
        //过滤条件
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("id",id);

        return userMapper.deleteByExample(example);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Override
    public Integer updateUserById(User user) {
        Integer result = userMapper.updateByPrimaryKeySelective(user);
        return result;
    }

    @Override
    public User queryUserById(Integer id) {
        //过滤条件
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("id",id);
        List<User> userList = userMapper.selectByExample(example);

        return userList.size()>0? userList.get(0):null;
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
