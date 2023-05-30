package com.example.MyBootProject.naver.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class WishListDto {
    private int index;
    private String title; // 주제
    private String category; //카테고리
    private String address; //주소
    private String readAddress; // 도로명
    private String homePageLink; //홈피주소
    private String imageLink; //이미지 주소
    private boolean isVisit; //방문여부
    private int visitCount; // 방문카운트
    private LocalDateTime lastVisitDate; //마지막 방문일자



}
