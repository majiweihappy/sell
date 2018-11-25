package com.imooc.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by majiwei
 * 2018/11/11 11:08
 */
public class JsonUtil
{
    public static String toJson(Object object)
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
