package com.star.tcs.dao;

import com.star.tcs.bean.Supply;

/**
 * Title: ISupplyDao.java
 * 功能：作业场地货源设置接口
 * author: star
 * Creation time: 2020-6-29 16.57
 * Modification time：
 * version： V1.0
 */
public interface ISupplyDao {

    /**
     * 根据位置名称返回货源类
     * @param location 位置
     * @return
     */
    public Supply findByLocation(String location);
}
