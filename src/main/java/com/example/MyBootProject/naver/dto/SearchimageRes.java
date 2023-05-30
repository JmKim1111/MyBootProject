package com.example.MyBootProject.naver.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchimageRes {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<SearchimageItem> items;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchimageItem{
        private String title;
        private String link;
        private String thumbnail;
        private String sizeheight;
        private String sizewidth;

    }


}
