package com.star.tcs.bean;
/**
 * Title: Supply.java
 * 功能：货源，各工作地点的要货和装货的莫表位置，实体类
 * author: star
 * Creation time: 2020-6-29 17：00
 * Modification time：
 * version： V1.0
 */
public class Supply {

    private String location;    //当前位置
    private String aims;        //目标位置
    private String type;        //目标位置的操作

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAims() {
        return aims;
    }

    public void setAims(String aims) {
        this.aims = aims;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "location='" + location + '\'' +
                ", aims='" + aims + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
