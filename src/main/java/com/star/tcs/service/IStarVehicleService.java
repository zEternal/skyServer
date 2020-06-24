package com.star.tcs.service;

import org.opentcs.data.model.Vehicle;

/**
 * Title: IStarVehicleService
 * 功能：车辆相关服务接口
 * author: star
 * Creation time: 2020-4-4 19:00
 * Modification time：
 * version： V1.0
 */
public interface IStarVehicleService {


    /**
     * 功能：返回对该车辆当前占用点的引用。
     * @param name 车名
     * @return 点
     */
    public String getCurrentPositionByName(String name);

    /**
     * 功能：返回能量相关
     * @param name 车名
     * @return 能量相关json
     */
    public String getEnergyByName(String name);

    /**
     * 功能：返回车辆在世界坐标[mm]中的位置，与逻辑位置/点名称无关
     * @param name 车名
     * @return position
     */
    public String getPrecisePositionByName(String name);

    /**
     * 功能：返回此车辆的当前状态。
     * @param name
     * @return
     */
    public String getStateByName(String name);

    /**
     * 功能：返回所有车辆名称
     * @return
     */
    public String getAllVehicle();

    /**
     * 返回此车辆的速度（以毫米/秒为单位）。
     * @param name
     * @return
     */
    public int getVelocityByName(String name);


}
