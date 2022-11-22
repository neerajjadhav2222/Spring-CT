package com.example.spring.ct.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Course {
    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy = "course")
    Set<StudentCourse> studentCourses;

    @Override
    public String toString() {
        return  "";
    }
}
