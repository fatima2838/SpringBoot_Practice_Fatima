package com.example.securityDemo3.model;


import com.example.securityDemo3.model.Subscription;
import com.example.securityDemo3.model.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    // Create a new Subscription
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    // Get all Subscriptions
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    // Get Subscription by subId
    public Optional<Subscription> getSubscriptionBySubId(Integer subId) {
        return subscriptionRepository.findByserviceId(subId);
    }

    // Get Subscriptions by UserId
  // Get Subscriptions by UserId
public List<Subscription> getSubscriptionsByUserId(Integer userId) {
    return subscriptionRepository.findByUserId(userId);
}

    // Get Subscriptions by PackageId
    public List<Subscription> getSubscriptionsByPackageId(Integer packageId) {
        return subscriptionRepository.findByPackageId(packageId);
    }

    // Update Subscription (if applicable)
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription); // This will update if the ID exists
    }

}
