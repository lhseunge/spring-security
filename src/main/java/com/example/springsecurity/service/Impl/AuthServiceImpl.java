package com.example.springsecurity.service.Impl;

import com.example.springsecurity.Domain.User;
import com.example.springsecurity.dto.SignInRequestDto;
import com.example.springsecurity.repository.UserRepository;
import com.example.springsecurity.service.AuthService;
import com.example.springsecurity.service.JwtTokenProvider;
import com.example.springsecurity.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    public AuthServiceImpl(UserService userService
                           , UserRepository userRepository
                           , JwtTokenProvider jwtTokenProvider
    ) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    private UserService userService;
    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String createToken(SignInRequestDto signInRequestDto) {

        User user = userRepository.findByUsername(signInRequestDto.getUsername());

        if (!signInRequestDto.getPassword().equals(user.getPassword())) {
            throw new IllegalStateException();
        }

        System.out.println("user validation pass");

        String accessToken = jwtTokenProvider.createToken(user.getUsername(), user.getAuthorities());

        return accessToken;

    }
}
