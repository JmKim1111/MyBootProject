package com.example.MyBootProject.controller;


import com.example.MyBootProject.dto.UserReq;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API")

public class TestController {

    @GetMapping
    public UserReq user(UserReq userReq){
        return userReq;
    }
}
