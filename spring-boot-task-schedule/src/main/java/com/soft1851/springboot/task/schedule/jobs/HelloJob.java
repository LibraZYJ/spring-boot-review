package com.soft1851.springboot.task.schedule.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Yujie_Zhao
 * @ClassName HelloJob
 * @Description TODO
 * @Date 2020/5/16  16:58
 * @Version 1.0
 **/
public class HelloJob implements Job {

    private int count;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello world!");
        count++;
    }
    public int getCount(){
        return count;
    }
}
