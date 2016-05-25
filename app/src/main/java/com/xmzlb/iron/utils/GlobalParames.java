package com.xmzlb.iron.utils;

import java.util.ArrayList;

/**
 * Created by zyz on 2016/5/17 0017.
 * QQ:344100167
 */
public class GlobalParames {
    public static ArrayList<String> list = new ArrayList<>();

    public static ArrayList<String> getList() {
        for (int i = 0; i < 5; i++) {
            list.add("123");
        }
        return list;
    }
}
