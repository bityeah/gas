package cn.demo.gas.task;

import cn.demo.gas.pay.service.StatService;
import cn.demo.gas.pay.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhaohg on 2017/8/4.
 */
@Component
public class ScheduledConfig {

    @Autowired
    private StatService statService;

    public final static long SECOND = 1 * 1000;

    @Scheduled(cron = "0/10 * * * * ?") // 每10秒执行一次
    public void scheduler() {

        Date dateMark = DateUtil.parse("2015-01-01");

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

        int i = 1;
        while (true) {
            if (initialYear > currentYear) break;
            if (initialYear == currentYear && initialMonth > currentMonth) break;
            if (initialYear == currentYear && initialMonth == currentMonth && initialDay >= currentDay) break;

            Date initData = DateUtil.addSubDay(initial.getTime(), i - 1);
            Date nextDate = DateUtil.addSubDay(initial.getTime(), i);
            //统计数据
//            statService.insertStatData(initData, nextDate);

            initialYear = DateUtil.getYear(nextDate.getTime());
            initialMonth = DateUtil.getMonth(nextDate.getTime());
            initialDay = DateUtil.getDay(nextDate.getTime());
            i++;
        }

        dateMark = initial.getTime();
        System.out.println(DateUtil.format(dateMark, "yyyy-MM-dd"));
    }


    /**
     //固定等待时间 @Scheduled(fixedDelay = 时间间隔 )
     @Scheduled(fixedDelay = SECOND * 2)
     public void fixedDelayJob() throws InterruptedException {
     TimeUnit.SECONDS.sleep(2);
     System.out.println("[FixedDelayJob Execute]" + new Date());
     }

     //固定间隔时间 @Scheduled(fixedRate = 时间间隔 )
     @Scheduled(fixedRate = SECOND * 4)
     public void fixedRateJob() {
     System.out.println("[FixedRateJob Execute]" + new Date());
     }
     */
}