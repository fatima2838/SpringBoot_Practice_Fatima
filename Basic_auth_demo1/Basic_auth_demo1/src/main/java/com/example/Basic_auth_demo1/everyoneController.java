package com.example.Basic_auth_demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class everyoneController {
  @GetMapping
    public String genericEndpoint() {
        return "Hello everyone!";
    }
}
