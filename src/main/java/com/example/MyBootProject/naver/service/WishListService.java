package com.example.MyBootProject.naver.service;

import com.example.MyBootProject.naver.NaverClient;
import com.example.MyBootProject.naver.dto.SearchLocalReq;
import com.example.MyBootProject.naver.dto.SearchimageReq;
import com.example.MyBootProject.naver.dto.WishListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;
    public WishListDto search(String query){

        //지역검색
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        //리스폰스 개념정의
        var searchLocalRes = naverClient.localSearch(searchLocalReq);
        // if문으로 getTotal
        if(searchLocalRes.getTotal() > 0){
            var item = searchLocalRes.getItems().stream().findFirst().get();

            var imageQuery = item.getTitle().replaceAll("<[^>]*>","");
            var searchImageReq = new SearchimageReq();
            searchImageReq.setQuery(imageQuery);

            //이미지검색
            var searchImageRes = naverClient.searchimageRes(searchImageReq);

            if(searchImageRes.getTotal() > 0){
                var imageItem = searchImageRes.getItems().stream().findFirst().get();
                //결과 리턴
                var result = new WishListDto();
                result.setTitle(item.getTitle());
                result.setCategory(searchLocalRes.getCategory());
                result.setAddress(item.getAddress());
                result.setReadAddress(item.getRoadAddress());
                result.setImageLink(imageItem.getLink());
                result.setHomePageLink(item.getLink());
                return result;

            }

        }


        return new WishListDto();


    }





}
