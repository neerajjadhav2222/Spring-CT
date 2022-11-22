package com.example.spring.ct.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Course {
    @Id
    private int id;

    private String name;
}
