package com.example.entities;

import java.util.*;

import com.example.entities.embeddables.Address;
import com.example.entities.embeddables.PersonalInformation;
import com.example.entities.enums.AcademicYear;

import jakarta.persistence.*;
import lombok.*;;

@Entity
@EqualsAndHashCode
@Getter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private PersonalInformation personalInformation;

    @Embedded
    private Address address;

    @Column(name = "grade" , nullable = false)
    private Double grade;

    @Column(name = "academic_year" , nullable = false)
    @Enumerated(EnumType.STRING)
    private AcademicYear academicYear;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "student_faculty",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "faculty_id")
    )
    private Set<Faculty> faculties = new HashSet<>();


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "student_lecturer",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "lecturer_id")
    )
    private Set<Lecturer> lecturers = new HashSet<>();


    public Student(final PersonalInformation personalInformation , final Address address , final Double grade , final AcademicYear year){
        this.personalInformation = personalInformation;
        this.address = address;
        this.grade = grade;
        this.academicYear = year;
    }

    public void addFaculty(final Faculty faculty){
        this.faculties.add(faculty);
        faculty.addStudent(this);
    }

    public void removeFaculty(final Faculty faculty){
        this.faculties.remove(faculty);
        faculty.removeStudent(this);
    }

    public void addLecturer(final Lecturer lecturer){
        this.lecturers.add(lecturer);
        lecturer.addStudent(this);
    }

    public void removeLecutrer(final Lecturer lecturer){
        this.lecturers.remove(lecturer);
        lecturer.addStudent(this);
    }

    protected Student(){}

}
