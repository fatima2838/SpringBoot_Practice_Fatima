package com.example.securityDemo3.model; 


import com.example.securityDemo3.model.MobilePackage;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePackageRepository extends JpaRepository<MobilePackage, Integer> {
   
    Optional<MobilePackage> findById(Integer id); // Get MobilePackage by ID
    Optional<MobilePackage> findByName(String name);
}
