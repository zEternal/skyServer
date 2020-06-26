package com.test.service;

import com.star.tcs.service.impl.StarTransportOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestOrder {

    private static Logger logger = LogManager.getLogger(TestOrder.class);

    @Test
    public void getAll(){
        StarTransportOrderService orderService = new StarTransportOrderService();
        orderService.getAllOrder();
    }
}
