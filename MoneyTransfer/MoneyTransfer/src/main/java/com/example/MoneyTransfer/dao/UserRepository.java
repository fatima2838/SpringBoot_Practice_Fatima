package com.example.MoneyTransfer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MoneyTransfer.entity.User;



public interface UserRepository extends JpaRepository<User, Integer> {

}
