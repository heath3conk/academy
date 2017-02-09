package com.allstate.services;

import com.allstate.entities.Course;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.allstate.enums.Gender.CENTAUR;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void shouldFindTeacherById() throws Exception {
        Teacher teacher = this.teacherService.findById(1);
        assertEquals(1, teacher.getId());
        assertEquals("t1", teacher.getName());
    }

    @Test
    public void shouldCreateTeacher() throws Exception {
        Teacher teacher = new Teacher("Bane", 90, Gender.CENTAUR);
        this.teacherService.createTeacher(teacher);
        assertEquals("Bane", teacher.getName());
        assertEquals(CENTAUR, teacher.getGender());
    }

    @Test
    public void shouldFindTeachersByGender() throws Exception {
        List<Teacher> teachers = this.teacherService.findByGender(Gender.FEMALE);
        assertEquals(1, teachers.size());

        Teacher newTeacher = new Teacher("Laura Ingalls", 90, Gender.FEMALE);
        this.teacherService.createTeacher(newTeacher);
        List<Teacher> updatedTeachers = this.teacherService.findByGender(Gender.FEMALE);
        assertEquals(2, updatedTeachers.size());
    }

    @Test
    public void shouldFindTeachersOverSomeAge() throws Exception {
        List<Teacher> teachers = this.teacherService.findByAgeGreaterThan(40);
        assertEquals(1, teachers.size());

        Teacher teacher = new Teacher("Bane", 90, Gender.CENTAUR);
        this.teacherService.createTeacher(teacher);
        List<Teacher> updatedTeachers = this.teacherService.findByAgeGreaterThan(40);
        assertEquals(2, updatedTeachers.size());
    }

    @Test
    @Transactional
    public void shouldFindAllClassesTaughtByATeacher() throws Exception {
        List<Course> courses = this.teacherService.findById(2).getCourses();
        assertEquals(2, courses.size());
    }

    @Test
    @Transactional
    public void shouldNotFindClassesForTeacherWhoHasNone() throws Exception {
        List<Course> courses = this.teacherService.findById(1).getCourses();
        assertEquals(0, courses.size());
    }
}