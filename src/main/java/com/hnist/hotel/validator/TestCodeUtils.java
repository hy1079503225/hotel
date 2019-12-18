package com.hnist.hotel.validator;

import com.hnist.hotel.utils.CodecUtils;


/**
 * @Filename
 * @auther 吴星辰;
 * @data 2019/12/7 10:52;
 * @Descripion
 * @Version 1.1.1
 * @Function
 * @History
 */
public class TestCodeUtils {


    public static void main(String[] args) {
        String pass = "admin";
        String hashPass = CodecUtils.passwordBcryptEncode("123",pass);
        System.out.println(hashPass);
        boolean flag = CodecUtils.passwordConfirm("123admin","$2a$10$jcknJMWSDZhymJr5pZ0O7uqbWM.q9BtFixevY0wwyvu8twfqsRcWG");
        System.out.println(flag);
    }

}
