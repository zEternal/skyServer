package com.star.tcs.controller;

import com.star.tcs.service.IStarTransportOrderService;
import com.star.tcs.service.impl.StarTransportOrderService;
import com.star.tcs.service.impl.StarVehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title: OrderController
 * 功能：订单Controller
 * author: star
 * Creation time: 2020-6-25 17.39
 * Modification time：
 * version： V1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    IStarTransportOrderService orderService = null;


    @RequestMapping("/getAll")
    @ResponseBody
    public String getAll(){

        orderService = new StarTransportOrderService();
        String all = orderService.getAllOrder();
        System.out.println("----" + all);
        return all;
    }



}
