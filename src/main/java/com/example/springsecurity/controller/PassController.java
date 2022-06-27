package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pass")
public class PassController {

    @GetMapping()
    public String getPass() {

        return "passed auth ...";
    }
}
