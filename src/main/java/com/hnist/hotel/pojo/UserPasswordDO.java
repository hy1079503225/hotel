package com.hnist.hotel.pojo;

public class UserPasswordDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_password.id
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_password.password
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_password.user_id
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_password.id
     *
     * @return the value of user_password.id
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_password.id
     *
     * @param id the value for user_password.id
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_password.password
     *
     * @return the value of user_password.password
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_password.password
     *
     * @param password the value for user_password.password
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_password.user_id
     *
     * @return the value of user_password.user_id
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_password.user_id
     *
     * @param userId the value for user_password.user_id
     *
     * @mbg.generated Tue Dec 10 16:13:45 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}