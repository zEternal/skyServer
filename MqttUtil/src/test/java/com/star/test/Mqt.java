package com.star.test;

import com.star.mqtt.util.MqttUtil;
import org.junit.Test;

public class Mqt {
    @Test
    public void testmq(){
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
