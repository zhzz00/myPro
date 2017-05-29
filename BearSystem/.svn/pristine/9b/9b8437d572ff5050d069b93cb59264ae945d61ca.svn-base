package com.bear.utils;

import com.alibaba.fastjson.JSONObject;


public class JsonUtil {


    //Json字符串 转 实体对象  
    public static final <T> T getObject(Class<T> clazz, String json){  
        return JSONObject.parseObject(json, clazz);  
    }  
   
    // 对象 转 Json字符串  
    public static final String getJsonString(Object o){  
        return JSONObject.toJSONString(o);  
    }  
      


}
