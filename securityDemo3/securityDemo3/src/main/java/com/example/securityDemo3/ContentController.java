package com.example.securityDemo3;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.securityDemo3.model.MobilePackage;
import com.example.securityDemo3.model.MobilePackageRepository;
import com.example.securityDemo3.model.MyUser;
import com.example.securityDemo3.model.MyUserRepository;
import com.example.securityDemo3.model.Subscription;
import com.example.securityDemo3.model.SubscriptionRepository;


// why is this @controller and the other a @rest controller ????? no answer yet // 


// this controller is for displaying pages 
@Controller
public class ContentController {

    @Autowired
    MyUserRepository repository ;

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    
    @Autowired
    MobilePackageRepository packageRepo;


  @GetMapping("/home")
  public String handleWelcome() {
    return "home";
  }

  @GetMapping("/admin/home")
  public String handleAdminHome(@AuthenticationPrincipal User user, Model model) {
    // info from spring security 
    String username = user.getUsername(); 
    //info from my username 
    MyUser myuser = repository.findByUsername(username)
                        .orElseThrow(()-> new UsernameNotFoundException("admin user not found")); 
            model.addAttribute("username", myuser.getUsername()); 
            model.addAttribute("role",myuser.getRole()); 
       return "home_admin";   }


// new user home 
@GetMapping("/user/home")
    public String handleUserHome(@AuthenticationPrincipal User user, Model model) {
        String username = user.getUsername();
        MyUser myUser = repository.findByUsername(username)
                              .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    
        model.addAttribute("username", myUser.getUsername()); 
        model.addAttribute("role", myUser.getRole()); 
    
        // Fetch subscriptions and add to model
      List<Subscription> subscriptions = subscriptionRepository.findByUserId(myUser.getId().intValue());
      List<MobilePackage> packages = new ArrayList<>();

      for (Subscription sub : subscriptions) {
   
    Optional<MobilePackage> pkg = packageRepo.findById(sub.getPackageId());
    pkg.ifPresent(packages::add);
}

model.addAttribute("packages", packages);

        return "home_user";
    } 
    

    //old 
    /* @GetMapping("/user/home")
 public String handleUserHome(@AuthenticationPrincipal User user, Model model) {
     String username = user.getUsername();
    MyUser myUser = repository.findByUsername(username)
                          .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    model.addAttribute("username", myUser.getUsername()); 
    model.addAttribute("role", myUser.getRole()); 
    
   return "home_user";
 }*/
    

  @GetMapping("/login")
  public String handleLogin() {
    return "CustomLogin";
  }
}