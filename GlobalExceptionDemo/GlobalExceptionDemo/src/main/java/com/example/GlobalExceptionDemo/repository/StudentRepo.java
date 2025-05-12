package com.example.GlobalExceptionDemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GlobalExceptionDemo.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>  {

}

