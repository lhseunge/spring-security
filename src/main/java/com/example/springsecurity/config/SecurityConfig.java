package com.example.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .cors().and() //이 구문은 안에 들어가보면 주석으로 내용이 나와있지만 CorsFilter라는 필터가 존재하는데 이를 활성화 시키는 작업입니다.
                .csrf().disable() // 세션을 사용하지 않고 JWT 토큰을 활용하여 진행하고 REST API를 만드는 작업이기때문에 csrf 사용은 disable 처리합니다.
                .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                .authorizeRequests() // 이제부터 인증절차에 대한 설정을 진행하겠다는 것입니다.
    //                .antMatchers() //특정 URL 에 대해서 어떻게 인증처리를 할지 결정합니다.
                    .antMatchers("/api/v1/test/auth").permitAll() // 해당 api는 인증 없이 접속 가능
                    .antMatchers("/api/v1/test/apis").permitAll()
                    .antMatchers().anonymous()
                .anyRequest().authenticated();


//                .permitAll();  //스프링 시큐리티에서 인증이 되지 않더라도 통과시켜 누구에게나 사용을 열어줍니다.



        return httpSecurity.build();
    }
}
