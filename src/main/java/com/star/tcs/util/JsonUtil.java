package com.star.tcs.util;
/**
 * Title: JsonUtil
 * 功能：json格式操作类
 * author: star
 * Creation time: 2020-6-29 16.14
 * Modification time：
 * version： V1.0
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil<T> {

    /**
     * json转java类
     * @param str json字符串
     * @param t 类class
     * @return 对象
     */
    public Object getObject(String str, T t){
        //Class<?> sClass = (T)Class.forName(t.getClass());

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(str, t.getClass());
        }
        catch (JsonProcessingException ex) {
            ex.printStackTrace();
            System.out.println(JsonUtil.class.getName()+"********");
            //Logger.getLogger(JsonUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
