package com.example.securityDemo3;


import com.example.securityDemo3.model.MyUser;
import com.example.securityDemo3.model.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    /*THIS METHOD IS FOR REGISTRATION LOGIC, ONCE EXECUTED NEW USER WILL BE SAVED TO DATABASE 
     * 1. INPUT IS USER OBJECT= REQUEST_BODY U CAN INPUT JSON IN POSTMANT 
     * 2.  NOTE THAT POST DOESNT RETURN A PAGE 
     * 3. REPOSITORY.SAVE() "Saves a given entity AND RETURNS IT. TO Use for further operations" 
     * 4. password encoder here knows to use bycrypt becuase its been configured 
     * STEPS : 
     * FIRST WE HASH THE PASS USING A PASSWORD ENCODER OBJECT (FROM SPRING BOOT)
     * second USE REPO.SAVE() TO SAVE THE USER WITH THE HASHED PASSWORD 
     * 
     */
    
    @PostMapping("/register/user")
    public MyUser createUser(@RequestBody MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return myUserRepository.save(user);
    }

    
}