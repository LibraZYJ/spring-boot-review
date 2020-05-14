package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Clazz;
import com.soft1851.springboot.jpa.model.cascade.Course;
import com.soft1851.springboot.jpa.model.cascade.Student;
import com.soft1851.springboot.jpa.model.cascade.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName ClassesRepository
 * @Description TODO
 * @Date 2020/5/14  16:46
 * @Version 1.0
 **/
@SpringBootTest
@Slf4j
public class ClassesRepository {
    @Resource
    private TeacherRepository teacherRepository;
    @Resource
    private ClazzRepository clazzRepository;
    @Resource
    private StudentRepository studentRepository;

    @Resource
    private CourseRepository courseRepository;

    @Test
    void testOneToOne() {
        List<Teacher> teachers = teacherRepository.findAll();
        teachers.forEach(System.out::println);
//        Clazz clazz = clazzRepository.findClazzByIdEquals(1);
//        System.out.println(clazz);
//        teacherRepository.deleteById(2);
    }

    @Test
    void testOneToMany() {
//        List<Student> students = studentRepository.findByClazzId(1);
        Clazz clazz = clazzRepository.findClazzByIdEquals(1);
//        clazz.setStudentList(students);
        System.out.println(clazz);
//        clazzRepository.deleteById(2);
    }

    @Test
    void testManyToMany() {
        System.out.println("**************************");

        List<Student> students = studentRepository.findByClazzId(1);
        students.forEach(student -> {
            System.out.println("学号："+student.getId() + "," + student.getStudentName() + "," + student.getAge());
            List<Course> courseList = student.getCourseList();
            courseList.forEach(course -> {
                System.out.println("课号："+course.getId() + ", 课程名称：" + course.getCourseName());
            });
        });
    }
    @Test
    void testManyToMany2(){
//        Course course = courseRepository.findCourseByCourseName("java");
//        System.out.println(course);
        List<Course> courses = courseRepository.findByCourseId(1);
        System.out.println(courses);

//        List<Course> courses = courseRepository.findByCourseId(1);
//        courses.forEach(course -> {
//            System.out.println(course.getId() +","+course.getCourseName());
//            List<Student> studentList = course.getStudentList();
//            studentList.forEach(student -> {
//                System.out.println(student.getId()+","+student.getStudentName());
//            });
//        });
    }
}
