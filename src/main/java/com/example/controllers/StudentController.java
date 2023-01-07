package com.example.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.entities.Student;
import com.example.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;


    public StudentController(final StudentService service){
        this.service = service;
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return this.service.findAll();
    }
    
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") final Long id){
        return this.service.findById(id);
    }
}
