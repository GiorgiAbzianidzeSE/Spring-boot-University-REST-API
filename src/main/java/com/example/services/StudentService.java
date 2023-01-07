package com.example.services;

import java.util.List;

import com.example.entities.Student;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);
    
}
