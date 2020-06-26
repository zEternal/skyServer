package com.star.tcs.controller;
/**
 * Title: VehicleController
 * 功能：车辆信息Controller
 * author: star
 * Creation time:
 * Modification time：2020-6-25 17：00
 * version： V1.0
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.star.tcs.service.IStarVehicleService;
import com.star.tcs.service.impl.StarVehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/getMap")
    @ResponseBody
    public String getMap(){

        List<Map<String,Object>> list = new ArrayList();

        Map<String, Object> one = new HashMap<>();
        one.put("number", "001");

        List listBefore = new ArrayList();
        listBefore.add("1");
        listBefore.add("2");
        listBefore.add("3");
        one.put("before", listBefore);
        one.put("now","4");
        List listAfter = new ArrayList();
        listAfter.add("5");
        listAfter.add("6");
        listAfter.add("7");
        listAfter.add("8");
        one.put("after", listAfter);

        list.add(one);

        Map<String, Object> two = new HashMap<>();
        two.put("number", "002");

        List listBefore2 = new ArrayList();
        listBefore2.add("1");
        listBefore2.add("2");
        listBefore2.add("3");
        two.put("before", listBefore2);
        two.put("now","4");
        List listAfter2 = new ArrayList();
        listAfter2.add("5");
        listAfter2.add("6");
        listAfter2.add("7");
        listAfter2.add("8");
        two.put("after", listAfter2);

        list.add(two);

        ObjectMapper om = new ObjectMapper();
        String path = null;
        try {
            path = om.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            System.out.println("json转换异常");
            e.printStackTrace();
        }

        return path;
    }

}
