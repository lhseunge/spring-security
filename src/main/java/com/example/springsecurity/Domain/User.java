package com.example.springsecurity.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USER")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "USERNAME", length = 50, unique = true)
    private String username;

    @Column(name = "PASSWORD", length = 100)
    private String password;

    @Column(name = "NICKNAME", length = 50)
    private String nickname;

    @Column(name = "ACTIVATED")
    private boolean activated;

    @ManyToMany
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_NAME", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;
}