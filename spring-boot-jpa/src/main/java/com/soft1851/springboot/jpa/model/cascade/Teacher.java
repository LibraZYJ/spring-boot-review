package com.soft1851.springboot.jpa.model.cascade;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Yujie_Zhao
 * @ClassName Teacher
 * @Description TODO
 * @Date 2020/5/13  21:15
 * @Version 1.0
 **/
@Entity
@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column( name = "teacher_name",nullable = false,length = 30)
    private String teacherName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clazz_id",referencedColumnName = "id")
    private Clazz clazz;
}
