package com.star.tcs.service;

/**
 * Title: IStarTransportOrderService
 * 功能：相关服务接口
 * author: star
 * Creation time: 2020-4-4 21:24
 * Modification time：
 * version： V1.0
 *
 * Modification time：2020-6-28  20：47
 * V1.1
 */
public interface IStarTransportOrderService {

    /**
     * 功能：请求装货
     *
     * @param locationName 地点名称
     * @return 订单名
     */
    public String requestToLoadGoods(String locationName);

    /**
     * 功能：请求卸货
     *
     * @param locationName 地点名称
     * @return 订单名
     */
    public String requestToUnload(String locationName);

    /**
     * 创建连续订单，根据当前位置从数据库查找固定目的
     * @param locationName  当前位置
     * @param aims 目的位置
     * @return
     */
    public String orderQueue(String locationName,String loType,String aims,String aiType);

    /**
     * 功能：根据订单名称返回订单创建时间
     * @param orderName 订单
     * @return
     */
    public String getCreationTimeByName(String orderName);

    /**
     * 功能：根据订单名称返回订单完成的时间
     * @param orderName
     * @return
     */
    public String getFinishedTimeByName(String orderName);

    /**
     * 功能：返回所有订单
     * @return
     */
    public String getAllOrder();

    /**
     * 功能：返回对当前正在处理此运输订单的车辆的引用。
     * @return
     */
    public String getProcessingVehicle(String orderName);

    /**
     * 功能：此订单经过的位置序列
     * @return
     */
    public String getPathByName(String orderName);

    /**
     * 返回此运输订单的当前状态。
     * @param orderName
     * @return
     */
    public String getStateByName(String orderName);
}

