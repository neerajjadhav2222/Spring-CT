package com.example.spring.ct.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Student {
    @Id
    private int id;

    private String name;

    private String email;

    private String phone;

    @OneToMany(mappedBy = "student")
    Set<StudentCourse> studentCourses;

    @Override
    public String toString() {
        return  "";
    }
}
