package com.firstspring.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class hellocontroller {

    @RequestMapping("/demo")
    public String hello() {
        return "Hello world";
    }
    
}
