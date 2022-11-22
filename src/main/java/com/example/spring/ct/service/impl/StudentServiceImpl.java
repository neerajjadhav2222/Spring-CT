package com.example.spring.ct.service.impl;

import com.example.spring.ct.dto.GetStudentByCourseDTO;
import com.example.spring.ct.dto.GetStudentDTO;
import com.example.spring.ct.entity.Course;
import com.example.spring.ct.entity.Student;
import com.example.spring.ct.entity.StudentCourse;
import com.example.spring.ct.repository.CourseRepository;
import com.example.spring.ct.repository.StudentCourseRepository;
import com.example.spring.ct.repository.StudentRepository;
import com.example.spring.ct.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentCourseRepository studentCourseRepository;


    @Override
    public List<GetStudentDTO> get() {
        List<Student> students = studentRepository.findAll();
        List<GetStudentDTO> getStudentDTOS = new ArrayList<GetStudentDTO>();
        for (Student student : students) {
            GetStudentDTO getStudentDTO = new GetStudentDTO();
            getStudentDTO.setId(student.getId());
            getStudentDTO.setName(student.getName());
            getStudentDTO.setEmail(student.getEmail());
            getStudentDTO.setCourses(courseRepository.findAllById(
                    student.getStudentCourses().stream().map(
                                    sc -> sc.getCourse().getId())
                            .collect(Collectors.toList())));
            getStudentDTOS.add(getStudentDTO);
        }
        return getStudentDTOS;
    }

    @Override
    public List<Student> getByCourse(int courseId) {
        List<StudentCourse> studentCourses = studentCourseRepository.findAllByCourseId(courseId);

        List<Student> students = new ArrayList<Student>();
        for( StudentCourse sc : studentCourses ){
            students.add(studentRepository.findById(sc.getStudent().getId()).get());
        }
        return students;
    }

    @Override
    public int assignCourse(int studentId, int courseId) {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudent(studentRepository.getById(studentId));
        studentCourse.setCourse(courseRepository.getById(courseId));
        return studentCourseRepository.save(studentCourse).getId();
    }
}
