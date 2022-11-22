package com.example.spring.ct.controller;

import com.example.spring.ct.entity.Course;
import com.example.spring.ct.repository.CourseRepository;
import com.example.spring.ct.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/spring-ct/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentCourseRepository studentCourseRepository;

    @DeleteMapping("/delete/{courseId}")
    @Transactional
    public ResponseEntity<Integer> delete(@PathVariable int courseId) {
        Course course = courseRepository.getById(courseId);
        studentCourseRepository.deleteByCourseId(course.getId());
        courseRepository.delete(course);
        return ResponseEntity.ok(courseId);
    }
}
