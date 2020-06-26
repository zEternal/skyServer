package com.jsont;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrO {

    @Test
    public void test(){
        ObjectMapper om = new ObjectMapper();
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
        try {
            String ss = om.writeValueAsString(list);
            System.out.println(ss);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
