package cn.demo.gas.pay.util;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by zhaohg on 2017/7/27.
 */
public class Util {

    public static int toInteger(Object obj, int defaultValue) {
        if (obj == null) {
            return defaultValue;
        }

        if (obj instanceof Integer) {
            return (Integer)obj;
        }

        return NumberUtils.toInt(obj.toString(), defaultValue);
    }
}
