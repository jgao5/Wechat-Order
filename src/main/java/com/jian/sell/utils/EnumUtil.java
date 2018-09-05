package com.jian.sell.utils;

import com.jian.sell.enums.CodeEnum;

public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each : enumClass.getEnumConstants()){
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
