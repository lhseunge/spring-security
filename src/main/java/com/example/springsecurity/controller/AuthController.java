package com.example.springsecurity.controller;

import com.example.springsecurity.dto.SignInRequestDto;
import com.example.springsecurity.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    private final AuthService authService;

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody @Validated SignInRequestDto signInRequestDto) {

        String accessToken = authService.createToken(signInRequestDto);

        return new ResponseEntity<String>(accessToken, HttpStatus.OK);
    }

    @PostMapping("/")
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
