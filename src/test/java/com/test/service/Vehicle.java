package com.test.service;

import com.star.tcs.service.impl.StarVehicleService;
import org.junit.Test;

public class Vehicle {

    @Test
    public void testPath(){
        StarVehicleService starVehicleService = new StarVehicleService();
        starVehicleService.getPaths("Vehicle-01");
    }

    @Test
    public void testAll(){
        StarVehicleService starVehicleService = new StarVehicleService();
        starVehicleService.getPaths("Vehicle-01");
    }



}
