package com.soft1851.springboot.jpa.model.cascade;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName Clazz
 * @Description TODO
 * @Date 2020/5/13  21:20
 * @Version 1.0
 **/
@Entity
@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column( name = "clazz_name",nullable = false,length = 20)
    private String clazzName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "clazz_id")
    private List<Student> studentList = new ArrayList<>();
}
