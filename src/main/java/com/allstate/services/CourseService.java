package com.allstate.services;


import com.allstate.entities.Course;
import com.allstate.repositories.ICourseRepository;
import com.allstate.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    //private IStudentRepository studentRepository;
    private ICourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

//    @Autowired
//    public void setStudentRepository(IStudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    Course findById(int id) {
        return this.courseRepository.findOne(id);
    }

    Course findByName(String name) {
        return this.courseRepository.findByName(name);
    }

    public Course createCourse(Course course) {
        return this.courseRepository.save(course);
    }
}
