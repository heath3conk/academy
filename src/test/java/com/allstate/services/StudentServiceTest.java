package com.allstate.services;

import com.allstate.entities.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void shouldCreateNewStudent() throws Exception {
        Student student = this.studentService.create("bob@aol.com");
        assertEquals(6, student.getId());
        assertEquals("bob@aol.com", student.getEmail());
    }

    @Test
    public void shouldFindByID() throws Exception {
        Student student = this.studentService.create("carl@aol.com");
        assertEquals(this.studentService.findById(6).getId(), student.getId());
    }

    @Test
    public void shouldFindByEmail() throws Exception {
        Student student = this.studentService.create("don@aol.com");
        assertEquals(this.studentService.findByEmail("don@aol.com").getEmail(), student.getEmail());
    }
}