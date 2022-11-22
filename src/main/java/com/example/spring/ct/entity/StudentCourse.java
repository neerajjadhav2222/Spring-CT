package com.example.spring.ct.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class StudentCourse {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    Course course;

    @Override
    public String toString() {
        return  "";
    }
}
