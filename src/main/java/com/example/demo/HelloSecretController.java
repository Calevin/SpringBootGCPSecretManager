package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSecretController {
    @Value("${greeting}")
    String greeting;

    @Value("${greeting_prop}")
    String greetingProp;

    @GetMapping("/")
    public String hello() {
        return greeting + greetingProp + " World!";
    }
}
