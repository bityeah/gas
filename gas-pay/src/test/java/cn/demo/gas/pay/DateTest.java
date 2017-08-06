package cn.demo.gas.pay;

import cn.demo.gas.pay.util.DateUtil;

import java.util.Date;

/**
 * Created by zhaohg on 2017/8/6.
 */
public class DateTest {
    public static final String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
        Date day = DateUtil.parse(DateUtil.getCurrentDay());
        System.out.println("当天：" + DateUtil.format(day, FORMAT_FULL));

        Date preDay = DateUtil.addSubDay(day, -1);
        System.out.println("昨天：" + DateUtil.format(preDay, FORMAT_FULL));

        Date week = DateUtil.addSubDay(day, -7);
        System.out.println("周" + DateUtil.format(week, FORMAT_FULL));

        Date toMonth = DateUtil.parse(DateUtil.getCurrentMonth());
        System.out.println("当月：" + DateUtil.format(toMonth, FORMAT_FULL));

        Date preMonth = DateUtil.addSubMonth(toMonth, -1);
        System.out.println("上月：" + DateUtil.format(preMonth, FORMAT_FULL));

        Date year = DateUtil.parse(DateUtil.getCurrentYear());
        System.out.println("当年：" + DateUtil.format(year, FORMAT_FULL));

        Date preYear = DateUtil.addSubYear(year, -1);
        System.out.println("去年：" + DateUtil.format(preYear, FORMAT_FULL));


    }
}
