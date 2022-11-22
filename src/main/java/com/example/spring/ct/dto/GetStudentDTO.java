package com.example.spring.ct.dto;

import com.example.spring.ct.entity.Course;
import lombok.Data;

import java.util.List;

@Data
public class GetStudentDTO {
    private int id;

    private String name;

    private String email;

    private String phone;

    private List<Course> courses;

}
