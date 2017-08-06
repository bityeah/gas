package cn.demo.gas.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaohg on 2017/8/4.
 */
@Component
public class ScheduledConfig {

    public final static long SECOND = 1 * 1000;

    @Scheduled(cron = "0/10 * * * * ?") // 每10秒执行一次
    public void scheduler() {
        System.out.println("111");
    }

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

}