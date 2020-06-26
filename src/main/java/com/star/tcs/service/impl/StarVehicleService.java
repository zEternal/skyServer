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
import org.opentcs.data.model.Triple;
import org.opentcs.data.model.Vehicle;

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


    public static Vehicle getVehicle(String name) {
        return vehicleService.fetchObject(Vehicle.class,name);
    }
}
