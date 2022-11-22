package com.example.spring.ct.service;

import com.example.spring.ct.dto.GetStudentDTO;
import com.example.spring.ct.entity.Student;

import java.util.List;

public interface StudentService {
    List<GetStudentDTO> get();
    List<Student> getByCourse(int courseId);
    int assignCourse(int studentId, int courseId);
}
