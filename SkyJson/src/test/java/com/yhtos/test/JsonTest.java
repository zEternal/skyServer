package com.yhtos.test;

import com.yhtos.tcs.util.Car;
import com.yhtos.tcs.util.JsonUtil;
import org.junit.Test;

public class JsonTest {

    @Test
    public void testj(){
        String str = "{\n" +
                "  \"name\":\"车辆名称\",\n" +
                "  \"energ\":\"能量\",\n" +
                "  \"location\":\"位置\",\n" +
                "  \"state\":\"状态\",\n" +
                "  \"position\":{\"x\":\"12\",\"y\":\"56\"}}";
        JsonUtil jsonUtil = new JsonUtil();

        Car car = (Car)jsonUtil.getObject(str,new Car());
        System.out.println(car.toString());
    }
}
//{"name":"车辆名称","energ":"能量","state":"状态","point":"Point-0025"}
