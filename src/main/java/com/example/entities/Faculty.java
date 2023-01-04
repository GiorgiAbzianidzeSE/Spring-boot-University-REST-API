package com.example.entities;

import java.util.*;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "faculty")
@EqualsAndHashCode
@ToString
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @ManyToMany(mappedBy = "faculties" , cascade = CascadeType.PERSIST)
    private Set<Lecturer> lecturers = new HashSet<>();

    @ManyToMany(mappedBy = "faculties" , cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<>();

    public Faculty(final String name){
        this.name = name;
    }

    public void addLecturer(final Lecturer lecturer){
        this.lecturers.add(lecturer);
        lecturer.addFaculty(this);
    }

    public void removeLecutrer(final Lecturer lecturer){
        this.lecturers.remove(lecturer);
        lecturer.removeFaculty(this);
    }

    public void addStudent(final Student student){
        this.students.add(student);
        student.addFaculty(this);
    }

    public void removeStudent(final Student student){
        this.students.remove(student);
        student.removeFaculty(this);
    }

    protected Faculty(){}
}
