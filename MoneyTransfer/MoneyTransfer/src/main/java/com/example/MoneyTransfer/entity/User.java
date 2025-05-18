package com.example.MoneyTransfer.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// lobmok annotations 
@Data
@AllArgsConstructor
@NoArgsConstructor


// jpa annotations 
@Entity
@Table(name = "Bank_Customer")
public class User {
@Id	
@GeneratedValue
private int id;

private String name;
private double balance; 
}