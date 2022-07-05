package com.example.springsecurity.controller;

import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    public ResponseEntity getUser() {

        return new ResponseEntity(userService.findById("id"), HttpStatus.OK);
    }
}
