package com.example.spring.ct.service.impl;

import com.example.spring.ct.repository.StudentRepository;
import com.example.spring.ct.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void assignCourse(int studentId, int courseId) {

    }
}
