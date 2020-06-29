package com.star.tcs.init;

import com.star.tcs.util.MqttMessageListenerImpl;
import com.star.tcs.util.MqttUtil;

public class InitServer {

    public void init(){
        MqttUtil mqttUtil = new MqttUtil();
        //初始化
        MqttUtil.init("mqtt.properties");
        //连接
        mqttUtil.connect();

        System.out.println("-----------------------");
        //订阅功能，按此格式
        mqttUtil.subscribe("kaim",0,new MqttMessageListenerImpl());

        //发布功能，按此格式
        mqttUtil.publish("kaim","789",0);
    }
}
