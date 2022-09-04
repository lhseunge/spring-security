package com.example.springsecurity.config;

import com.example.springsecurity.service.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/h2-console/**"
                , "/favicon.ico"
                , "/error");
    }
//
//        web.ignoring()
//                .antMatchers("/resources/**")
//                .antMatchers("/css/**")
//                .antMatchers("/vendor/**")
//                .antMatchers("/js/**")
//                .antMatchers("/favicon*/**")
//                .antMatchers("/img/**")
//                ;


    /**
     *
     * @param httpSecurity
     * @return
     * @throws Exception
     *
     * 다음은 antMatchers()로 지정할 수 있는 항목들입니다.
     *
     * hasRole() or hasAnyRole()특정 권한을 가지는 사용자만 접근할 수 있습니다.
     * hasAuthority() or hasAnyAuthority()특정 권한을 가지는 사용자만 접근할 수 있습니다.
     * hasIpAddress()특정 아이피 주소를 가지는 사용자만 접근할 수 있습니다.
     * permitAll() or denyAll()접근을 전부 허용하거나 제한합니다.
     * rememberMe()리멤버 기능을 통해 로그인한 사용자만 접근할 수 있습니다.
     * anonymous()인증되지 않은 사용자가 접근할 수 있습니다.
     * authenticated()인증된 사용자만 접근할 수 있습니다.
     *
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .httpBasic().disable() // rest api 이므로 기본설정 사용안함. 기본설정은 비인증시 로그인폼 화면으로 리다이렉트 된다.
                .cors().and() //이 구문은 안에 들어가보면 주석으로 내용이 나와있지만 CorsFilter라는 필터가 존재하는데 이를 활성화 시키는 작업입니다.
                .csrf().disable() // 세션을 사용하지 않고 JWT 토큰을 활용하여 진행하고 REST API를 만드는 작업이기때문에 csrf 사용은 disable 처리합니다.
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests() // 이제부터 인증절차에 대한 설정을 진행하겠다는 것입니다.
                //                .antMatchers() //특정 URL 에 대해서 어떻게 인증처리를 할지 결정합니다.
//                    .antMatchers("/**").permitAll() // 해당 api는 인증 없이 통과시켜 누구에게나 OPEN
                .antMatchers("/health").permitAll()
                .antMatchers("/pass/**").permitAll()
                .antMatchers("/security/v1/**").authenticated()
//                    .antMatchers().anonymous()
//                    .anyRequest().authenticated()
        ;

        return httpSecurity.build();
    }
}
