package com.example.securityDemo3;

import org.springframework.web.bind.annotation.RestController;

import com.example.securityDemo3.model.MobilePackageRepository;
import com.example.securityDemo3.model.MyUser;
import com.example.securityDemo3.model.MyUserRepository;
import com.example.securityDemo3.model.Subscription;
import com.example.securityDemo3.model.SubscriptionService;
import com.example.securityDemo3.model.subDTO;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SubscriptionController {

@Autowired
private MyUserRepository userRepo; 

@Autowired
public MobilePackageRepository package_repo; 

@Autowired
public SubscriptionService subservice; 

    @PostMapping("/subscribe")
    public Subscription Subscribe(@RequestBody subDTO mydto) {

    System.out.println("Received subscription request with body: " + mydto);

          Double currentBalance = userRepo.findById(mydto.getUserId())
                                .orElseThrow()
                                .getBalance();
        Double price = package_repo.findById(mydto.getPackageId())
                            .orElseThrow()
                            .getPrice();
           Double newbalance = currentBalance - price; 
           MyUser user = userRepo.findById(mydto.getUserId()).orElseThrow();
            user.setBalance(newbalance);
            userRepo.save(user);

            // update new balance 

        Subscription newsub = new Subscription(mydto.getUserId(), mydto.getPackageId(), LocalDate.now() ); 

        subservice.createSubscription(newsub); 
        
        return newsub;
    }



    
}
