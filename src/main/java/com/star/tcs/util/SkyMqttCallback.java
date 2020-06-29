package com.star.tcs.util;
/**
 * Title:SkyMqttCallback.java
 * 功能；MQTT回调
 * Author: star
 * Creation time: 2020-6-29 10:42
 * Modification time：
 * Version： V1.0
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SkyMqttCallback  implements MqttCallback {

    private static Logger logger = LogManager.getLogger(SkyMqttCallback.class);

    @Override
    public void connectionLost(Throwable thrwbl) {
        //logger.info("--SkyMqttCallback--  Server connection lost");
        logger.info("服务器的连接丢失");
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        logger.info("在完成消息传递并收到所有确认后调用。");
        //System.out.println("--SkyMqttCallback--  Called after completing the message delivery and receiving all confirmations.");
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {
        logger.info("--SkyMqttCallback--  Got the news");
        logger.info("--Topic==" + string);
        logger.info("--message==" + mm.toString());


    }
}
