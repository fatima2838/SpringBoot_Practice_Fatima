package com.example.securityDemo3.model;

import com.example.securityDemo3.model.MobilePackage;
import com.example.securityDemo3.model.MobilePackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MobilePackageService {

    @Autowired
    private MobilePackageRepository mobilePackageRepository;

    // Create a new Mobile Package
    public MobilePackage createMobilePackage(MobilePackage mobilePackage) {
        return mobilePackageRepository.save(mobilePackage);
    }

    // Get all Mobile Packages
    public List<MobilePackage> getAllMobilePackages() {
        return mobilePackageRepository.findAll();
    }

    // Get Mobile Package by ID
    public Optional<MobilePackage> getMobilePackageById(Integer id) {
        return mobilePackageRepository.findById(id);
    }

    // Update Mobile Package
    public MobilePackage updateMobilePackage(MobilePackage mobilePackage) {
        return mobilePackageRepository.save(mobilePackage); // This will update if the ID exists
    }

    // Delete Mobile Package by ID
    public void deleteMobilePackage(Integer id) {
        mobilePackageRepository.deleteById(id);
    }

    // Find Mobile Package by Name (if needed)
    public Optional<MobilePackage> getMobilePackageByName(String name) {
        return mobilePackageRepository.findByName(name);
    }
}
