package com.soft1851.springboot.task.schedule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yujie_Zhao
 * @ClassName InternalApiController
 * @Description TODO
 * @Date 2020/5/17  23:55
 * @Version 1.0
 **/
// 内部接口的 URL 路径以 /internal/ 作为前缀
@Controller
public class InternalApiController {
    @GetMapping("/internal/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello internal");
    }
}