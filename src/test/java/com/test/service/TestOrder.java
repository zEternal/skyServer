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

    @Test
    public void create(){
        StarTransportOrderService orderService = new StarTransportOrderService();
        //String name  = orderService.orderQueue("Goods out 01","Goods in north 01");
        //logger.info("order*****"+name);
        //Goods out 01     Storage 01
    }

    @Test
    public void createLoad(){
        StarTransportOrderService orderService = new StarTransportOrderService();

        String name2  = orderService.requestToLoadGoods("Goods out 01");
        logger.info("order2*****"+name2);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String name  = orderService.requestToUnload("Goods in north 01");
        logger.info("order*****"+name);



    }

}
