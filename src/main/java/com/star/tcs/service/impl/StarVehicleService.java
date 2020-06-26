package com.star.tcs.service.impl;
/**
 * Title: StarVehicleService
 * 功能：车辆相关服务实现
 * author: star
 * Creation time: 2020-4-4 19:00
 * Modification time：
 * version： V1.0
 */
import com.star.tcs.service.IStarVehicleService;
import com.star.tcs.util.KopenTCSUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opentcs.access.KernelServicePortal;
import org.opentcs.components.kernel.services.VehicleService;
import org.opentcs.data.TCSObjectReference;
import org.opentcs.data.model.Triple;
import org.opentcs.data.model.Vehicle;
import org.opentcs.data.order.DriveOrder;
import org.opentcs.data.order.OrderSequence;
import org.opentcs.data.order.TransportOrder;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class StarVehicleService implements IStarVehicleService {


    private static Logger logger = LogManager.getLogger(StarVehicleService.class);
    private static KernelServicePortal kernelServicePortal = null;
    private static VehicleService vehicleService = null;
    private static Vehicle vehicle = null;
    static {
        kernelServicePortal = KopenTCSUtil.getKernelServicePortal();
        vehicleService = kernelServicePortal.getVehicleService();
    }



    @Override
    public String getCurrentPositionByName(String name) {
        vehicle = getVehicle(name);
        String position = vehicle.getCurrentPosition().getName();
        logger.info("***** " + name + " at " + position + " point *****");
        return position;
    }

    @Override
    public String getEnergyByName(String name) {
        vehicle = getVehicle(name);
        int energy = vehicle.getEnergyLevel();
        String energys = energy + "%";
        logger.info("***** the energy of " + name + " : " + energys + " *****");
        return null;
    }

    /*!!!!!!!!!!!!暂时别用这个，有错         */
    @Override
    public String getPrecisePositionByName(String name) {
        vehicle = getVehicle(name);
        Triple triple = vehicle.getPrecisePosition();
        logger.info("***** " + name + " : " + triple.toString() + " *****");
        return triple.toString();
    }

    @Override
    public String getStateByName(String name) {
        vehicle = getVehicle(name);
        Vehicle.ProcState vp = vehicle.getProcState();
        logger.info("***** " + vp.toString() + " *****");
        return vp.toString();
    }

    @Override
    public String getAllVehicle() {

        String allv = "[{\"car_id\":\"vehicle-01\",\"car_electric\":\"99\",\"car_state\":\"0\",\"carry_num\":\"null\"}," +
                "{\"car_id\":\"vehicle-02\",\"car_electric\":\"99\",\"car_state\":\"0\",\"carry_num\":\"null\"}," +
                "{\"car_id\":\"vehicle-03\",\"car_electric\":\"99\",\"car_state\":\"0\",\"carry_num\":\"null\"}]";

        return allv;
    }

    @Override
    public int getVelocityByName(String name) {
        vehicle = getVehicle(name);
        int velocity  = vehicle.getMaxVelocity();
        logger.info("***** " + velocity + " *****");
        return velocity;
    }

    //返回指定车辆正在处理得订单序列
    public void getPaths(String name){

        vehicle = getVehicle(name);
        logger.info("车辆名称：" + vehicle.getName());

        //返回对该车辆当前正在处理的订单序列的引用。
        TCSObjectReference<TransportOrder> transportOrder= vehicle.getTransportOrder();
        requireNonNull(transportOrder,"orderSequence nullllllll");
        StarTransportOrderService starTransportOrderService = new StarTransportOrderService();
        starTransportOrderService.getTo(transportOrder);
        //返回TCSObject给定类的单个。
        /*OrderSequence os = vehicleService.fetchObject(OrderSequence.class,orderSequence);
        //返回组成该序列的订单列表。
        List<TCSObjectReference<TransportOrder>> list = os.getOrders();
        for (TCSObjectReference<TransportOrder> tot : list) {
            TransportOrder tOrder = vehicleService.fetchObject(TransportOrder.class,tot);
            //DriveOrder driveOrder = tOrder.getCurrentDriveOrder();
            String orderName =  tOrder.getName();
            logger.info("订单名称：" + orderName);
        }*/

    }


    /**
     * 获取车辆
     * @param name 车名
     * @return 车辆类
     */
    public static Vehicle getVehicle(String name) {
        return vehicleService.fetchObject(Vehicle.class,name);
    }
}
