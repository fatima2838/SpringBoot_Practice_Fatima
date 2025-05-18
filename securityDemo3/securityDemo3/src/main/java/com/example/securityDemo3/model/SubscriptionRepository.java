package com.example.securityDemo3.model;

import com.example.securityDemo3.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    Optional<Subscription> findByserviceId(Integer subId);
    List<Subscription> findByUserId(Integer userId);
    List<Subscription>  findByPackageId(Integer packageId); // Get Subscription by packageId
}
