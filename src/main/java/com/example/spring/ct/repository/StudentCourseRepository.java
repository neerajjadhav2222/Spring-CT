package com.example.spring.ct.repository;

import com.example.spring.ct.entity.Student;
import com.example.spring.ct.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {

    void deleteByCourseId(int courseId);

    List<StudentCourse> findAllByCourseId(int courseId);
}
