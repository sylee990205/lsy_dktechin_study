package com.example.springedu3.controller;

import com.example.springedu3.entity.Friend;
import com.example.springedu3.service.FriendDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@RestController
public class HomeController {
    @Autowired
    FriendDaoService service;
    @GetMapping("/hello")
    public String hello() {
        return "환영합니다~~~ HomeController 의 처리 결과입니다.";
    }
    @GetMapping("/user")
    public String user() {
        return "로그인을 하면 누구든 볼 수 있는 페이지 입니다.";
    }
    @GetMapping("/atype")
    public String aaa() {
        return "A 로서의 ROLE 이 부여된 사용자만 볼 수 있는 페이지 입니다.";
    }
    @GetMapping("/btype")
    public String bbb() {
        return "B 로서의 ROLE 이 부여된 사용자만 볼 수 있는 페이지 입니다.";
    }
    @GetMapping("/premium")
    public String ccc() {
        return "primium 로서의  권한(AUTH)이 부여된 사용자만 볼 수 있는 페이지 입니다.";
    }
    @GetMapping("/day")
    public String day() {
        LocalDate ld = LocalDate.now();
        DayOfWeek dow = ld.getDayOfWeek();
        String korDay = dow.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
        return korDay;
    }
    @GetMapping("/friends")
    public ResponseEntity<List<Friend>> friends() {
        ResponseEntity<List<Friend>> entity = new ResponseEntity<>(service.friendList(), HttpStatus.OK);
        return entity;
    }
}
