package com.hnist.hotel.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.hnist.hotel.config.AliPayConfig;
import com.hnist.hotel.error.BusinessException;
import com.hnist.hotel.pojo.Order;
import com.hnist.hotel.service.OrderService;
import com.hnist.hotel.service.impls.AliPayService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class PayController {

    @Autowired
    AliPayService aliPayService;
    @Autowired
    AliPayConfig aliPayConfig;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/payTest")
    public void testPay(HttpServletResponse httpResponse){
        String form = aliPayService.genPage();
        httpResponse.setContentType("text/html;charset=" + aliPayConfig.CHARSET);
        try{
            httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
   }


    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
//    @ResponseBody
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException, BusinessException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
//            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params
                ,aliPayConfig.ALIPAY_PUBLIC_KEY, aliPayConfig.CHARSET, aliPayConfig.SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);

            //支付成功，修复支付状态
            aliPayService.updateById(out_trade_no);
            Order order = new Order();
            orderService.createOrder(order.getUserId(),order.getUserCardid(),order.getHotelId(),order.getRoomType(),order.getRoomNumber(),order.getOrderCost());
            return "redirect:before/index.html";//跳转付款成功页面
        }else{
            return "redirect:";//跳转付款失败页面
        }
    }
    @GetMapping("/refund")
    @ResponseBody
    public void test_trade_refund(String outTradeNo,HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        try{
            PrintWriter out = response.getWriter();
            String result = aliPayService.refund(outTradeNo);
            out.println(result);//以下写自己的订单退款代码
        } catch (AlipayApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
