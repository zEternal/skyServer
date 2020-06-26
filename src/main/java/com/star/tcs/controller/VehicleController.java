package com.star.tcs.controller;
/**
 * Title: VehicleController
 * 功能：车辆信息Controller
 * author: star
 * Creation time:
 * Modification time：2020-6-25 17：00
 * version： V1.0
 */
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

    @RequestMapping("/getAll")
    @ResponseBody
    public String getAll(){

        starVehicleService = new StarVehicleService();
        String cp = starVehicleService.getAllVehicle();
        System.out.println("----" + cp);
        return cp;
    }

}
