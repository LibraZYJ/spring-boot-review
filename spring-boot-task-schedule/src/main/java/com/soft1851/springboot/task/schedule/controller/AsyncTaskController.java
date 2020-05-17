package com.soft1851.springboot.task.schedule.controller;

import com.soft1851.springboot.task.schedule.service.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @author Yujie_Zhao
 * @ClassName AsynsTaskService
 * @Description TODO
 * @Date 2020/5/16  16:14
 * @Version 1.0
 **/

@RestController
@Slf4j
public class AsyncTaskController {
    @Resource
    private AsyncTaskService asyncTaskService;

    @RequestMapping("/asyncTask")
    public String asyncTask(){
        asyncTaskService.asyncTask();
        return "测试异步任务";
    }


    @RequestMapping("/mailTask")
    public String mailTask() throws MessagingException {
        asyncTaskService.mailTask();
        return "发送邮件成功";
    }
}
