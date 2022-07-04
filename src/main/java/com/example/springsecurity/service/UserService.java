package com.example.springsecurity.service;

import com.example.springsecurity.Domain.User;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> findById(String id) {

        return userRepository.findById(id);
    }

//    public Optional<User> find
}
