package com.example.h2.jpa.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.h2.jpa.demo.dao.UserRepository;
import com.example.h2.jpa.demo.entity.User;

@Service
public class UserService {
    @Autowired
    private UserRepository user_repository; 
    
    public User createUser(User user){
         return user_repository.save(user); 
    }
    public List<User> createUsers(List<User> user){
        return user_repository.saveAll(user); 
   }

    public User getUserById(int id){
        return user_repository.findById(id).orElse(null); 

    }

    public List<User> getAllUsers(){
        return user_repository.findAll();  
    }
// not clear 
    public User updateUser(User user) {
		User oldUser=null;
		Optional<User> optionaluser=user_repository.findById(user.getId());
		if(optionaluser.isPresent()) {
			oldUser=optionaluser.get();
			oldUser.setName(user.getName());
			oldUser.setAddress(user.getAddress());
			user_repository.save(oldUser);
		}else {
			return new User();
		}
		return oldUser;
	}
public String deleteUserById(int id){
    user_repository.deleteById(id);
    return "user got deleted"; 

}


}
 