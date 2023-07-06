package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    public String signIn() {

        return "token";
    }

    public String signOut() {

        return "token invalidate";
    }

    public String signUp() {

        return "add user";
    }

    public String withdraw() {

        return "withdraw user";
    }

}
