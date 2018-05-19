package com.bootdo.common.utils;

import java.util.UUID;

/**
 * create with idea
 * author: xiaoniao
 * Date: 2018/5/18
 * Time: 13:02
 */
public class UuidUtils {
    public static String getUUID32(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;

    }
}
