package com.soft1851.springboot.task.schedule.task;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Yujie_Zhao
 * @ClassName task1
 * @Description TODO
 * @Date 2020/5/14  19:49
 * @Version 1.0
 **/
//@Component
public class Task1 {
    private int count = 0;

    /**
     * 设置process()每隔5秒执行一次，并统计执行次数
     */
    @Scheduled(cron = "*/5 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task running " +(count++));
    }
}
