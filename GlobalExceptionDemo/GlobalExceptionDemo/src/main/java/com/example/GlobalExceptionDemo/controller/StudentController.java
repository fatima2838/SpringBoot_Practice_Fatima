package com.example.GlobalExceptionDemo.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.GlobalExceptionDemo.exception.StudentNotFoundException;
import com.example.GlobalExceptionDemo.model.Student;
import com.example.GlobalExceptionDemo.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) throws StudentNotFoundException {
		Student studentById = studentService.getStudentById(id);
		return ResponseEntity.ok(studentById);
	}
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
		Student savedStudent = studentService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
	}
	
	@PutMapping
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws StudentNotFoundException {
	    Student updatedStudent = studentService.updateStudent(student);
	    return ResponseEntity.ok(updatedStudent);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) throws StudentNotFoundException {
	     studentService.deleteStudent(id);
	     return ResponseEntity.noContent().build();
	}
}
