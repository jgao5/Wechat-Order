package com.jian.sell.controller;

import com.jian.sell.dto.OrderDTO;
import com.jian.sell.enums.ResultEnum;
import com.jian.sell.execption.SellException;
import com.jian.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public void create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl") String returnUrl){

        // 1. 查询订单
        OrderDTO orderDTO = orderService.findById(orderId);
        if (orderDTO == null){
            throw new SellException((ResultEnum.ORDER_NOT_EXIST));
        }

        // 发起支付


    }
}
