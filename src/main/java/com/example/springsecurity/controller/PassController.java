package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pass")
public class PassController {

    @GetMapping("/permit")
    public String getPassToPermit() {

        return "permitAll ...";

    }

    @GetMapping("/webconfig")
    public String getPassToWebConfig() {

        return "web config ...";

    }

    @GetMapping("/lunch")
    public String getTodayLunch() {

        List<String> menu = List.of(
                "길농원",
                "신선촌",
                "희래등",
                "삼성골",
                "뒤끝",
                "쌀국수",
                "크치벅",
                "족보마을",
                "칼국수",
                "샐러드",
                "카마치",
                "푸카",
                "아지매",
                "담미온",
                "록스"

        );


        int random = (int) (Math.random() * menu.size());

        return String.format("%s!", menu.get(random));

    }
}
