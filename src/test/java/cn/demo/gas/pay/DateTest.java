package cn.demo.gas.pay;

import cn.demo.gas.pay.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhaohg on 2017/8/6.
 */
public class DateTest {
//    public static final String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
//        Date day = DateUtil.parse(DateUtil.getCurrentDay());
//        System.out.println("当天：" + DateUtil.format(day, FORMAT_FULL));
//
//        Date preDay = DateUtil.addSubDay(day, -1);
//        System.out.println("昨天：" + DateUtil.format(preDay, FORMAT_FULL));
//
//        Date week = DateUtil.addSubDay(day, -7);
//        System.out.println("周" + DateUtil.format(week, FORMAT_FULL));
//
//        Date toMonth = DateUtil.parse(DateUtil.getCurrentMonth());
//        System.out.println("当月：" + DateUtil.format(toMonth, FORMAT_FULL));
//
//        Date preMonth = DateUtil.addSubMonth(toMonth, -1);
//        System.out.println("上月：" + DateUtil.format(preMonth, FORMAT_FULL));
//
//        Date year = DateUtil.parse(DateUtil.getCurrentYear());
//        System.out.println("当年：" + DateUtil.format(year, FORMAT_FULL));
//
//        Date preYear = DateUtil.addSubYear(year, -1);
//        System.out.println("去年：" + DateUtil.format(preYear, FORMAT_FULL));


        stat();

    }

    public static void stat() {
        Date dateMark = DateUtil.parse("2016-08-16");

        Calendar initial = Calendar.getInstance();
        initial.setTime(dateMark);
        int initialYear = initial.get(Calendar.YEAR);
        int initialMonth = initial.get(Calendar.MONTH) - 1;
        int initialDay = initial.get(Calendar.DATE);

        Calendar current = Calendar.getInstance();
        current.add(Calendar.MONTH, 1);
        int currentYear = current.get(Calendar.YEAR);
        int currentMonth = current.get(Calendar.MONTH) - 1;
        int currentDay = current.get(Calendar.DATE);

//        int i = 1;
//        while (true) {
//            if (initialYear > currentYear) break;
//            if (initialYear == currentYear && initialMonth > currentMonth) break;
//            if (initialYear == currentYear && initialMonth == currentMonth && initialDay >= currentDay) break;
//
//            Date initData = DateUtil.addSubDay(initial.getTime(), i - 1);
//            Date nextDate = DateUtil.addSubDay(initial.getTime(), i);
//            //统计数据
//            StatDataStats(initData, nextDate);
//
//            initialYear = DateUtil.getYear(nextDate.getTime());
//            initialMonth = DateUtil.getMonth(nextDate.getTime());
//            initialDay = DateUtil.getDay(nextDate.getTime());
//            i++;
//        }

        dateMark = initial.getTime();
        System.out.println(DateUtil.format(initial.getTime(),"yyyy-MM-dd"));
    }

    public static void StatDataStats(Date startTime, Date endTime) {
        System.out.println("start="+ DateUtil.format(startTime,"yyyy-MM-dd") +"     end="+ DateUtil.format(endTime,"yyyy-MM-dd") );

    }
}
