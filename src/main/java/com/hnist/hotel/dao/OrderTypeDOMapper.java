package com.hnist.hotel.dao;

import com.hnist.hotel.pojo.OrderTypeDO;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTypeDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_type
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_type
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    int insert(OrderTypeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_type
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    int insertSelective(OrderTypeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_type
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    OrderTypeDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_type
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    int updateByPrimaryKeySelective(OrderTypeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_type
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    int updateByPrimaryKey(OrderTypeDO record);
}