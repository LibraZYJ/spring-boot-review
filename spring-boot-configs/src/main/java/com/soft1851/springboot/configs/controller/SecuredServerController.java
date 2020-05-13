package com.soft1851.springboot.configs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author Yujie_Zhao
 * @ClassName SecuredServerController
 * @Description HTTPS测试
 * @Date 2020/5/12  16:06
 * @Version 1.0
 **/
@RestController
@Slf4j
class SecuredServerController {

    @RequestMapping("/secured")
    public String secured() {
        log.info("Inside secured()");
        return "Hello user !!! : " + LocalDateTime.now();
    }
}