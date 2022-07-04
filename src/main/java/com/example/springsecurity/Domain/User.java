package com.example.springsecurity.Domain;


import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @Column(name = "user_no")
    private int userNo;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_pw")
    private String userPw;

    @Column(name = "user_name")
    private String userName;


    public User findByIdandPw() {

        return new User();
    }
}
