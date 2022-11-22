package com.example.spring.ct.controller;

import com.example.spring.ct.dto.GetStudentDTO;
import com.example.spring.ct.entity.Student;
import com.example.spring.ct.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring-ct/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<List<GetStudentDTO>> get() {
        List<GetStudentDTO> student = studentService.get();
        return ResponseEntity.ok(student);
    }

    @PutMapping("/assign-course/{studentId}/{courseId}")
    public ResponseEntity<Object> assignCourse(@PathVariable int studentId, @PathVariable int courseId) {
        int id = studentService.assignCourse(studentId, courseId);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/get/{courseId}")
    public ResponseEntity<List<Student>> getByCourse(@PathVariable int courseId) {
        return ResponseEntity.ok(studentService.getByCourse(courseId));
    }
}
