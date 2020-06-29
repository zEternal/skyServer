package com.star.tcs.util;
/**
 * Title: MqttMessageListenerImpl.java
 * 功能：订阅客户端的回调监听实现
 * author: star
 * Creation time: 2020-6-29 16.57
 * Modification time：
 * version： V1.0
 */
import com.star.tcs.bean.ClientJob;
import com.star.tcs.bean.Supply;
import com.star.tcs.dao.SupplyDaoImpl;
import com.star.tcs.service.impl.StarTransportOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttMessageListenerImpl implements IMqttMessageListener {
    private static Logger logger = LogManager.getLogger(MqttMessageListenerImpl.class);
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        String data = message.toString();
        logger.info("---订阅到：" + topic + ":" + data);

        JsonUtil jsonUtil = new JsonUtil();
        ClientJob job = (ClientJob) jsonUtil.getObject(message.toString(), new ClientJob());
        logger.info("json转为对象" + job.toString());

        SupplyDaoImpl supplyDao = new SupplyDaoImpl();
        Supply supply = supplyDao.findByLocation(job.getLocation());
        logger.info("查目标位置：" + supply.toString());

        StarTransportOrderService orderService = new StarTransportOrderService();
        String name  = orderService.orderQueue(job.getLocation(),job.getType(),supply.getAims(),supply.getType());


    }
}
