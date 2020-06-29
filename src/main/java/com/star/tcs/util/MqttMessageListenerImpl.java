package com.star.tcs.util;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttMessageListenerImpl implements IMqttMessageListener {
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("-+-MqttMessageListenerImpl--  Got the news");
        System.out.println("-+-Topic==" + topic);
        System.out.println("-+-message==" + message.toString());



    }
}
