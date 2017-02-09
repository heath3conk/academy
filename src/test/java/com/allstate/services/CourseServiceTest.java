package com.allstate.services;

import com.allstate.entities.Course;
//import com.allstate.entities.Teacher;
import com.allstate.entities.Teacher;
import com.allstate.enums.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;


    @Test
    public void shouldCreateNewCourse() throws Exception {
        Teacher teacher = this.teacherService.findById(1);
        Course course = new Course("Principles of Flight 101", Date.valueOf(LocalDate.now()), 4, Department.AERONAUTICS, 500);
        course.setTeacher(teacher);
        course = this.courseService.createCourse(course);
        assertEquals(4, course.getId());
        assertEquals("t1", course.getTeacher().getName());
    }

    @Test
//    @Transactional
    public void shouldFindOneCourseById() throws Exception {
        Course course = this.courseService.findById(1);
        assertEquals(1, course.getId());
        //assertEquals(3, course.getStudents().size());
    }


    @Test
    public void shouldFindOneCourseByName() throws Exception {
        Course course = this.courseService.findByName("Basket Beanies 401");
        assertEquals("Basket Beanies 401", course.getName());
    }

    @Test
    @Transactional
    public void shouldFindTeacherGivenAClass() throws Exception {
        Teacher teacher = this.courseService.findByName("Basket Beanies 401").getTeacher();
        assertEquals(3, teacher.getId());
    }
}