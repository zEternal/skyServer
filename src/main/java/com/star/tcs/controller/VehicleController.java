package com.star.tcs.controller;

import com.star.tcs.service.IStarVehicleService;
import com.star.tcs.service.impl.StarVehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    IStarVehicleService starVehicleService = null;

    //根据名字获取该车辆当前占用的点
    @RequestMapping("/getCPByName")
    @ResponseBody
    public String getCurrentPositionByName(String name){

        starVehicleService = new StarVehicleService();
        String cp = starVehicleService.getCurrentPositionByName(name);
        return "";
    }

}
