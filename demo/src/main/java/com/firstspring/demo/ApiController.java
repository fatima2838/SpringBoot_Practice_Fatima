package com.firstspring.demo;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/get-todos")
    public String getTodos() {
        return apiService.getTodos();
    }


    
}
