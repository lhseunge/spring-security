package com.example.springsecurity.service;

import com.example.springsecurity.Domain.Authority;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.hibernate.tool.schema.spi.ExecutionOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${jwt.secretKey}")
    private String SECRET_KEY;

    @Value("${jwt.expiredTime}")
    private Long EXPIRED_TIME;

    private Key ENCODED_SECRET_KEY;

    private final UserDetailsService userDetailsService;

    @PostConstruct
    protected void init() {
//        SECRET_KEY = Base64.getEncoder().encodeToString(SECRET_KEY.getBytes());
        ENCODED_SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(String username, Set<Authority> roles) {

        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", roles);
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + EXPIRED_TIME))
                .signWith(ENCODED_SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }


    public String getUserPk(String token) {

        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String jwtToken) {

        try {

            Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken);

            return !claims.getBody().getExpiration().before(new Date());

        } catch (Exception e) {
            return false;
        }
    }
}
