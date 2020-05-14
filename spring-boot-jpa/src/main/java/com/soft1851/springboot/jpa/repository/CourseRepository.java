package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName CourseRepository
 * @Description TODO
 * @Date 2020/5/14  16:24
 * @Version 1.0
 **/
public interface CourseRepository extends JpaRepository<Course, Integer> {
    /**
     * 根据课程名称查询
     *
     * @param courseName
     * @return
     */
    Course findCourseByCourseName(String courseName);

    /**
     * 根据班级id查询学生列表
     *
     * @param id
     * @return
     */
    @Query(value = "select id,course_name from course where course_id = ?1",nativeQuery = true)
    List<Course> findByCourseId(int id);
}