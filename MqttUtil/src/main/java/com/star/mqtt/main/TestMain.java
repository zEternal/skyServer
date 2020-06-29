package com.star.mqtt.main;

import com.star.mqtt.util.MqttUtil;

public class TestMain {

    public static void main(String[] args) {
        MqttUtil mqttUtil = new MqttUtil();
        //初始化
        MqttUtil.init("mqtt.properties");
        //连接
        mqttUtil.connect();


        System.out.println("-----------------------");
        //订阅功能，按此格式
        mqttUtil.subscribe("kaim",0);

        //发布功能，按此格式
        mqttUtil.publish("kaim","789",0);
    }
}
