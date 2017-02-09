package com.allstate.repositories;

import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITeacherRepository extends CrudRepository<Teacher, Integer> {


    List<Teacher> findByGender(Gender gender);

    List<Teacher> findByAgeGreaterThan(int age);
}
