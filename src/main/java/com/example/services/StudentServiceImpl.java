package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.Student;
import com.example.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository repository;

    public StudentServiceImpl(final StudentRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Student> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return this.repository.findById(id).get();
    }
    
}
