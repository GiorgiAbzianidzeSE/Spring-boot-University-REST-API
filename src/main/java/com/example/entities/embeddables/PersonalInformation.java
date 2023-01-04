package com.example.entities.embeddables;

import java.time.LocalDate;

import com.example.entities.enums.Gender;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@EqualsAndHashCode
public class PersonalInformation {
    @Column(name = "first_name", length = 40, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 40, nullable = false)
    private String lastName;

    @Column(name = "e_mail", length = 40, nullable = false)
    private String eMail;

    @Column(name = "birth_Day", nullable = false)
    private LocalDate birthday;

    @Column(name = "gender", length = 40, nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public PersonalInformation(final String firstName, final String lastName, final String eMail,
            final LocalDate birthday , final Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.birthday = birthday;
        this.gender = gender;
    }

    protected PersonalInformation(){}

    

}
