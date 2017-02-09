package com.allstate.repositories;


import com.allstate.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface ICourseRepository extends CrudRepository<Course, Integer>{
    Course findByName(String name);

}
