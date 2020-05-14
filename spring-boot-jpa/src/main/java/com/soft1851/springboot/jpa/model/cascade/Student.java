package com.soft1851.springboot.jpa.model.cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName Student
 * @Description TODO
 * @Date 2020/5/13  17:50
 * @Version 1.0
 **/
@Entity
@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column( name = "student_name",nullable = false,length = 30)
    private String studentName;

    @Column( name = "age",nullable = false,length = 30)
    private Integer age;


    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courseList = new ArrayList<>();
}
