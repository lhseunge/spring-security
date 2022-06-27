package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security/v1")
public class SecurityController {

    @GetMapping("/hello-world")
    public String helloWorld() {

        return "Hello, World !!!";
    }

    @GetMapping("/auth")
    public String getAuth() {

        return "sueccess auth !!!";
    }

}
