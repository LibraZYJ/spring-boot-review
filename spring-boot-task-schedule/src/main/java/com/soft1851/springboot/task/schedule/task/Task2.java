package com.soft1851.springboot.task.schedule.task;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Yujie_Zhao
 * @ClassName Task2
 * @Description 定时任务在配置类上添加@EnableScheduling开启对定时任务的支持，
 * 在相应的方法上添加@Scheduled声明需要执行的定时任务。
 * @Date 2020/5/14  19:53
 * @Version 1.0
 **/
//@Component
public class Task2 {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");


    /**
     * fixedRate:固定频率执行
     */
    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime1(){
        System.out.println(Thread.currentThread().getName()+" Time1:  现在时间"+dtf.format(LocalDateTime.now()));

    }

    /**
     * fixedDelay:固定固定延迟
     */
    @Scheduled(fixedDelay = 3000)
    public void reportCurrentTime2(){
        System.out.println(Thread.currentThread().getName()+" Time2:  现在时间"+dtf.format(LocalDateTime.now()));

    }

    /**
     * 第一次延迟3秒，之后按照fixedDelay的规则没2秒执行一次
     */
    @Scheduled(initialDelay = 3000,fixedDelay = 2000)
    public void reportCurrentTime3(){
        System.out.println(Thread.currentThread().getName()+" Time3:  现在时间"+dtf.format(LocalDateTime.now()));
    }

    /**
     * 通过cron表达式定义规则
     */
    @Scheduled(cron="0/5 * * * * *")
    public void reportCurrentTime4(){
        System.out.println(Thread.currentThread().getName()+" Time4:  现在时间"+dtf.format(LocalDateTime.now()));
    }

    /**
     * 通过cron表达式定义规则
     */
    @Scheduled(cron="0 7 22 * * *")
    public void reportCurrentTime5(){
        System.out.println(Thread.currentThread().getName()+" Time5:  现在时间"+dtf.format(LocalDateTime.now()));
    }
}
