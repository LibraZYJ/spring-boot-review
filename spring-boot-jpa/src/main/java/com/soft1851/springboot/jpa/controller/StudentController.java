package com.soft1851.springboot.jpa.controller;

import com.soft1851.springboot.jpa.model.cascade.Student;
import com.soft1851.springboot.jpa.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName StudentController
 * @Description TODO
 * @Date 2020/5/14  16:28
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/api/student")
public class StudentController {
    @Resource
    private StudentRepository studentRepository;

    @GetMapping()
    public List<Student> getStudents(@RequestParam("clazzId") int id) {
        return studentRepository.findByClazzId(id);
    }
}