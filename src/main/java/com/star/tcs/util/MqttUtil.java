package com.star.tcs.util;
/**
 * Title:MqttUtil.java
 * 功能；mqtt操作
 * Author: star
 * Creation time: 2020-6-28 10:43
 * Modification time：
 * Version： V1.0
 *
 * Modification time：2020-6-29 19:05
 * Version： V1.1
 * 完善log，填加创建订单专用回调监听
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

public class MqttUtil {

    private static String url;      // = "tcp://127.0.0.1:1883";
    private static String username;// = "admin";
    private static String password;// = "admin";
    //private static int qos;// = 0;

    private MqttClient client;          //客户端对象
    private MqttConnectOptions options; //
    private static Logger logger = LogManager.getLogger(MqttUtil.class);
    /**
     * 功能：初始化
     * @param configFile
     */
    public static void init(String configFile) {
        Properties params = new Properties();
        InputStream in = MqttUtil.class.getClassLoader().getResourceAsStream(configFile);
        try {
            params.load(in);
        } catch (IOException e) {
            logger.info("配置文件解析异常");
            e.printStackTrace();
        }
        url=params.getProperty("url");
        username = params.getProperty("username");
        password = params.getProperty("password");
        //qos = Integer.parseInt(params.getProperty("qos"));
    }


    /**
     * 方法名：mqttClient
     * 功能：创建一个可用于与MQTT服务器通信的MqttClient。
     * @param url：服务器地址
     * @param id：客户端标识符，唯一
     * @return：MqttClient对象
     * @throws MqttException
     */
    public MqttClient mqttClient(String url, String id) throws MqttException {
        return new MqttClient(url, id);
    }

    /**
     * 功能：返回一个用于控制客户端如何连接到服务器的选项集。
     * @return ：MqttConnectOptions
     */
    public MqttConnectOptions getOptions(){
        /**
         * MqttConnectOptions使用默认值构造一个新对象。默认值为：
         *   存活间隔为60秒
         *   清洁会议是真的
         邮件传递重试间隔为15秒
         连接超时时间为30秒
         未设置意愿消息
         使用标准的SocketFactory
         */
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        return  options;
    }

    /**
     * 功能：创建MQTT连接
     * @throws MqttSecurityException
     * @throws MqttException
     */
    public void connect(){
        try {
            String id = ""+UUID.randomUUID();
            client = mqttClient(url, id);
            options = getOptions();
            client.setCallback(new SkyMqttCallback());
            client.connect(options);
            logger.info("---MQTT connection succeeded");
        } catch (MqttException e) {
            logger.info("---MQTT connection failed");
            e.printStackTrace();
        }

    }


    /*********************************订阅****************************************/
    /**
     * 功能：订阅一个主题，
     * @param topic：订阅主题
     * @param qos：订阅服务质量
     * @throws MqttException
     */
    public void subscribe(String topic, int qos){
        try {
            client.subscribe(topic,qos);
            logger.info("订阅:" + topic);
        } catch (MqttException e) {
            logger.info("***主题订阅失败:" + topic);
            e.printStackTrace();
        }
    }
    /**
     * 功能：订阅多个主题，每个主题都可以包含通配符。
     * @param topics ：要订阅的一个或多个主题，其中可以包含通配符。
     * @param qos ： 订阅每个主题的最高服务质量。
     * @throws MqttException
     */
    public void subscribe(String[] topics, int[] qos){
        try {
            client.subscribe(topics,qos);
            for(String topic : topics){
                logger.info("订阅:" + topic);
            }
        } catch (MqttException e) {
            logger.info("***主题订阅失败:" + topics.toString());
            e.printStackTrace();
        }

    }
    /**
     * 功能： 订阅主题，其中可能包括使用QoS为1的通配符。
     * @param topic：订阅的主题
     * @param messageListener ：处理传入消息的回调
     * @throws MqttException
     */
    public void subscribe(String topic,int qos, IMqttMessageListener messageListener){
        try {
            client.subscribe(topic, messageListener);
            logger.info("订阅:" + topic);
        } catch (MqttException e) {
            logger.info("***主题订阅失败:" + topic);
            e.printStackTrace();
        }
    }


    /************************************发布***********************************/
    public void publish(String topic, String payload, int qos){
        try {
            client.publish(topic, getMessage(payload, qos));
            logger.info("发布:" + topic + "++" + payload);
        } catch (MqttException e) {
            logger.info("****发布异常:" + topic);
            e.printStackTrace();
        }

    }
    public MqttMessage getMessage(String paylosd, int qos){
        MqttMessage message = new MqttMessage(paylosd.getBytes());
        message.setQos(qos);
        message.setRetained(true);
        return  message;
    }
}
