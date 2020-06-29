package com.star.tcs.dao;
/**
 * Title: SupplyDaoImpl.java
 * 功能：作业场地货源数据库操作类
 * author: star
 * Creation time: 2020-6-29 17.10
 * Modification time：
 * version： V1.0
 */
import com.star.tcs.bean.Supply;

public class SupplyDaoImpl implements ISupplyDao {
    @Override
    public Supply findByLocation(String location) {
        System.out.println("获取目标节点");
        Supply supply = new Supply();
        supply.setLocation(location);
        supply.setAims("Storage 01");
        supply.setType("NOP");
        return supply;
    }
}
