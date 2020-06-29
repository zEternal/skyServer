package com.star.mqtt.util;
/**
 * Title:
 * 功能；MQTT回调
 * Author: star
 * Creation time: 2020-6-29 10:42
 * Modification time：
 * Version： V1.0
 */

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SkyMqttCallback  implements MqttCallback {
    @Override
    public void connectionLost(Throwable thrwbl) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("服务器的连接丢失");
        System.out.println("--SkyMqttCallback--  Server connection lost");
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("在完成消息传递并收到所有确认后调用。");
        System.out.println("--SkyMqttCallback--  Called after completing the message delivery and receiving all confirmations.");
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("--SkyMqttCallback--  Got the news");
        System.out.println("--Topic==" + string);
        System.out.println("--message==" + mm.toString());


    }
}
