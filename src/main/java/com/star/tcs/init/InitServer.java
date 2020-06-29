package com.star.tcs.init;
/**
 * Title: InitServer.java
 * 功能：系统启动时
 * author: star
 * Creation time: 2020-6-29 16.57
 * Modification time：
 * version： V1.0
 */
import com.star.tcs.util.MqttMessageListenerImpl;
import com.star.tcs.util.MqttUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InitServer {
    private static Logger logger = LogManager.getLogger(InitServer.class);
    public void init(){
        logger.info("即将初始化MQTT");
        MqThread mt = new MqThread();
        mt.start();
    }


    public class MqThread extends Thread{
        @Override
        public void run() {
            logger.info("进入线程中");
            MqttUtil mqttUtil = new MqttUtil();
            //初始化
            MqttUtil.init("mqtt.properties");
            //连接
            logger.info("开始连接");
            mqttUtil.connect();

            //订阅功能，按此格式
            mqttUtil.subscribe("jobRequest",0,new MqttMessageListenerImpl());
            logger.info("订阅成功");
            //发布功能，按此格式
           // mqttUtil.publish("kaim","{\"location\":\"Goods out 01\",\"type\":\"NOP\"}",0);

        }
    }
}
