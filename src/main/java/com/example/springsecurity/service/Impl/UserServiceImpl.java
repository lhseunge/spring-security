package com.example.springsecurity.service.Impl;

import com.example.springsecurity.Domain.User;
import com.example.springsecurity.repository.UserRepository;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public Optional<User> findById(@PathVariable("id") String id) {

        return userRepository.findById(id);
    }

//    public Optional<User> find
}
