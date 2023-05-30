package com.example.MyBootProject.naver;


import com.example.MyBootProject.naver.dto.SearchLocalReq;
import com.example.MyBootProject.naver.dto.SearchimageReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverClientTest {

    @Autowired
    private NaverClient naverClient;
    @Test
    public void localSearchTest(){

        var search = new SearchLocalReq();
        search.setQuery("미용실");

        var result = naverClient.localSearch(search);
        System.out.println(result);
    }

    @Test
    public void searchImageTest(){
        var search = new SearchimageReq();
        search.setQuery("커피");


        var result = naverClient.searchimageRes(search);
        System.out.println(result);
        Assertions.assertNotNull(result);
    }
}
