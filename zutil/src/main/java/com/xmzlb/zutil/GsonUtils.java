package com.xmzlb.zutil;


import com.google.gson.Gson;

/**
 * Created by zyz on 2016/4/19 0019.
 * QQ:344100167
 * Gson解析相关工具
 */
public class GsonUtils {
    public static <T> T parseJSON(String json, Class<T> clazz) {
        Gson gson = new Gson();
        T info = gson.fromJson(json, clazz);
        return info;
    }
}
