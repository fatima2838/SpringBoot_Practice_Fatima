package com.example.GlobalExceptionDemo.model;



import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name ="students")
@NoArgsConstructor
public class Student implements Serializable {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Student name cannot be blank")
	private String name;
	@NotBlank(message = "Student address cannot be blank")
	private String address;

}
