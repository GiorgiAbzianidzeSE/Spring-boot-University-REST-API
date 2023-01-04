package com.example;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.entities.Faculty;
import com.example.entities.Lecturer;
import com.example.entities.embeddables.Address;
import com.example.entities.embeddables.PersonalInformation;
import com.example.entities.enums.Gender;

import jakarta.persistence.*;

@SpringBootApplication
public class UniversityRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityRestApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(EntityManagerFactory emf){
		return (args) -> {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			

			Lecturer lecturer = new Lecturer(new PersonalInformation("lasha", "lashashvili", "lasha@tsu.edu.ge", LocalDate.of(2000 , Month.AUGUST , 5) , Gender.MALE),
			 new Address("vaza", true, "3/4", 4789));


			lecturer.addFaculty(new Faculty("Computerr science"));

			em.persist(lecturer);

			em.getTransaction().commit();
		};
	}

}
