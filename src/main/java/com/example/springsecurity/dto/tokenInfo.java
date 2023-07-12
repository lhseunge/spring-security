package com.example.springsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class tokenInfo {

    private String accessToken;
    private String refreshToken;
}
