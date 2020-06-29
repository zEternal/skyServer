package com.star.tcs.bean;

import java.io.Serializable;

/**
 * Title: ClientJob.java
 * 功能：客户端发布请求作业数据实体类
 * author: star
 * Creation time: 2020-6-29 16.12
 * Modification time：
 * version： V1.0
 */
public class ClientJob implements Serializable {
    private String location;
    private String type;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ClientJob{" +
                "location='" + location + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
