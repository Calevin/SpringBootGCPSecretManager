package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSecretController {
    String greeting = "Hi";

    @GetMapping("/")
    public String hello() {
        return greeting + " World!";
    }
}
