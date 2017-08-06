package cn.demo.gas.pay.util;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    public static Map<String,Object> getWhereMap(int type){

        if(type == 1) {
            Date currentDay = DateUtil.parse(DateUtil.getCurrentDay());
            Date preDay = DateUtil.addSubDay(currentDay, -1);
            Map<String, Object> map = new HashMap<>();
            map.put("startTime", preDay);
            map.put("endTime", currentDay);

            return map;
        }
        else if(type == 2){
            Date day = DateUtil.parse(DateUtil.getCurrentDay());
            Date preDay = DateUtil.addSubDay(day, -7);
            Map<String, Object> map = new HashMap<>();
            map.put("startTime", preDay);
            map.put("endTime", day);
            return map;
        }
        else if(type == 3){
            Date month = DateUtil.parse(DateUtil.getCurrentMonth());
            Date nextMonth = DateUtil.addSubMonth(month,1);
            Map<String, Object> map = new HashMap<>();
            map.put("startTime", month);
            map.put("endTime", nextMonth);
            return map;
        }
        else if(type == 4){
            Date year = DateUtil.parse(DateUtil.getCurrentYear());
            Date nextYear = DateUtil.addSubYear(year,1);
            Map<String, Object> map = new HashMap<>();
            map.put("startTime", year);
            map.put("endTime", nextYear);
            return map;
        }

        return null;
    }
}
