package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teachers")
@Data
public class Teacher {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @Size(min = 1)
    @NotNull
    private String name;

    @Min(value = 21)
    @NotNull
    private int age;

    @Column(columnDefinition = "ENUM('FEMALE', 'CENTAUR')")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<Course> courses;

    public Teacher(){

    }

    public Teacher(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

}
