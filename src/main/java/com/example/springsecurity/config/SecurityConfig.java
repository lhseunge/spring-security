package com.example.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors().and() //이 구문은 안에 들어가보면 주석으로 내용이 나와있지만 CorsFilter라는 필터가 존재하는데 이를 활성화 시키는 작업입니다.
                .csrf().disable()
                .authorizeRequests()
                .antMatchers()
                .permitAll()
                .antMatchers()



        return httpSecurity;
    }
}
