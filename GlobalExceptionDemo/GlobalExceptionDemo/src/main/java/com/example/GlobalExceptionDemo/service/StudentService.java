package com.example.GlobalExceptionDemo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.GlobalExceptionDemo.exception.StudentNotFoundException;
import com.example.GlobalExceptionDemo.model.Student;
import com.example.GlobalExceptionDemo.repository.StudentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepo studentRepo;

	public Student getStudentById(int id) throws StudentNotFoundException {
		return studentRepo.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(String.format("Student not found with id %s", id)));
	}

	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	public Student updateStudent(Student student) throws StudentNotFoundException {
		Student existingStudent = studentRepo.findById(student.getId())
				.orElseThrow(() -> new StudentNotFoundException(String.format("Student not found with id %s", student.getId())));

		// 👇 Manually update fields
		existingStudent.setName(student.getName());
		existingStudent.setAddress(student.getAddress());
		// Add other fields as needed

		return studentRepo.save(existingStudent);
	}

	public void deleteStudent(int id) throws StudentNotFoundException {
		Student student = studentRepo.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(String.format("Student not found with id %s", id)));
		studentRepo.delete(student);
	}
}
