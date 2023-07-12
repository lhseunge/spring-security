package com.example.springsecurity.service;

import com.example.springsecurity.dto.SignInRequestDto;

public interface AuthService {

    String createToken(SignInRequestDto signInRequestDto);
}
