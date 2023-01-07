package com.example.entities;

import java.util.*;

import com.example.entities.embeddables.Address;
import com.example.entities.embeddables.PersonalInformation;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lecturer")
@Getter
@EqualsAndHashCode
@ToString
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** INFO:
     * @Column(name = "first_name" , length = 40 , nullable = false)
     *              private String firstName;
     * 
     * @Column(name = "last_name" , length = 40 , nullable = false)
     *              private String lastName;
     * 
     * @Column(name = "e_mail" , length = 40 , nullable = false)
     *              private String eMail;
     * 
     * @Column(name = "birthday" , length = 40 , nullable = false)
     *              private LocalDate birthday;
     * 
     * I used Embedded class, this code is equivalent to this.
     */
    @Embedded
    private PersonalInformation personalInformation;

    /* INFO:  
     * @Column(name = "street_name"  , length = 40 , nullable = false)
     * private String streetName;
     *
     * @Column(name = "lives_in_apartment" , length = 40 , nullable = false)
     * private Boolean livesInApartment;
     * 
     * @Column(name = "flat_number" , length = 40 , nullable = false)
     * private String flatNumber;
     * 
     * @Column(name = "zip_code" , length = 40 , nullable = false)
     * private Integer zipCode;
     * 
     * I used Embedded class, this code is equivalent to this.
     */
    @Embedded
    private Address address;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "lecturer_faculty", 
    joinColumns = @JoinColumn(name = "lecturer_id"), 
    inverseJoinColumns = @JoinColumn(name = "faculty_id")
    )
    private Set<Faculty> faculties = new HashSet<>();

    @ManyToMany(mappedBy = "lecturers",cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<>();

    public Lecturer(final PersonalInformation personalInformation,  final Address address) {
        this.personalInformation = personalInformation;
        this.address = address;
    }

    protected Lecturer(){}

    public void addFaculty(final Faculty faculty){
        this.faculties.add(faculty);
    }

    public void removeFaculty(final Faculty faculty){
        this.faculties.remove(faculty);
    }

    public void addStudent(final Student student){
        this.students.add(student);
        student.addLecturer(this);
    }

    public void removeStudent(final Student student){
        this.students.remove(student);
        student.removeLecutrer(this);
    }


}
