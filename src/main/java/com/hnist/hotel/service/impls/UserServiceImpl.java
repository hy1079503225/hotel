package com.hnist.hotel.service.impls;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hnist.hotel.mapper.UserMapper;
import com.hnist.hotel.pojo.PageResult;
import com.hnist.hotel.pojo.User;
import com.hnist.hotel.service.UserService;
import com.hnist.hotel.utils.CodecUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.hnist.hotel.pojo.PageParams;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public PageResult<User> getUserList(PageParams pageParams,String search,String search1) {
        search = "%" + search + "%";
        // 开始分页
        PageHelper.startPage(pageParams.getPage(), pageParams.getLimit());
        //查询条件，用户名，电话，身份证号码
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.orLike("username",search);
        criteria.orLike("name",search);
        criteria.orLike("phone",search);
        criteria.orLike("cardId",search);

        if (search1.equals("1")){
            Example.Criteria criteria1 = example.createCriteria();
            criteria1.andEqualTo("status",Integer.valueOf(search1));

            example.and(criteria1);
        }
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
     * 新增用户
     * @param user
     * @return
     */
    @Override
    public Boolean addUser(User user) {
        return userMapper.insertSelective(user)>0?true:false;
    }

    @Override
    public Map<String,String> login(Map<String, String> map) {
        Map<String,String> m=new HashMap<>();
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("username",map.get("username")).andEqualTo("type",1);
        User user=userMapper.selectOneByExample(example);
        if (user==null){
            m.put("code","400");
            m.put("msg","账号不存在");
            return m;
        }
        if (!CodecUtils.passwordConfirm(map.get("username")+map.get("password"),user.getPassword())){
            m.put("code","400");
            m.put("msg","密码错误");
            return m;
        }
        System.out.println(user);
        m.put("code","200");
        m.put("msg","登录cg");
        m.put("username1",user.getUsername());
        return m;
    }

    @Override
    public Map<String, String> adminlogin(Map<String, String> map) {
        Map<String,String> m=new HashMap<>();
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("username",map.get("username"));
        User user=userMapper.selectOneByExample(example);
        if (user==null||user.getType()==1){
            m.put("code","400");
            m.put("msg","账号不存在");
            return m;
        }
        if (!CodecUtils.passwordConfirm(map.get("username")+map.get("password"),user.getPassword())){
            m.put("code","400");
            m.put("msg","密码错误");
            return m;
        }
        System.out.println(user);
        m.put("code","200");
        m.put("msg","登录cg");
        m.put("username1",user.getUsername());
        return m;
    }

    @Override
    public User getUserbyUsername(String userName) {
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("username",userName);
        return  userMapper.selectOneByExample(example);
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
