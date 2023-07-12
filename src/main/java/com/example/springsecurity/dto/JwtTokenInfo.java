package com.example.springsecurity.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtTokenInfo {

    private String grantType;
    private String accessToken;
    private String refreshToken;

}
