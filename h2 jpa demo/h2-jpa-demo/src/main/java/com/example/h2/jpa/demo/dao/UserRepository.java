package com.example.h2.jpa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.h2.jpa.demo.entity.User;
public interface UserRepository extends JpaRepository<User, Integer> {

}
