package com.soft1851.springboot.task.schedule.test;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author Yujie_Zhao
 * @ClassName QuartzTest
 * @Description TODO
 * @Date 2020/5/16  16:55
 * @Version 1.0
 **/
public class QuartzTest {
    public static void main(String[] args) {
        try {
            //从工厂获取调度程序实例
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //启动
            scheduler.start();
            //停止
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
