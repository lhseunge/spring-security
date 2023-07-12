package com.example.springsecurity.controller;

import com.example.springsecurity.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/v1")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping()
    public ResponseEntity getUsers() {

        return new ResponseEntity(userServiceImpl.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") String id) {

        return new ResponseEntity(userServiceImpl.findById(id), HttpStatus.OK);
    }
}
