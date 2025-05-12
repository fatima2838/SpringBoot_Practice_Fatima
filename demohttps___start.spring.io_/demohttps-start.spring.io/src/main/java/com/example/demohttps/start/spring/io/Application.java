package com.example.demohttps.start.spring.io;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.example.demohttps.student.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	  @GetMapping
	public List<student> hello(){
		//this method returns a json array 
		return List.of(
			new student(
				1L, 
			 "Mariam",
			 "mariam.gmail.com" , 
			 LocalDate.of(2000,01,05),
			 21)
		); 

}
	
	
}
