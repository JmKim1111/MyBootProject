package com.example.MyBootProject.naver;


import com.example.MyBootProject.naver.service.WishListService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class WishListTest {

    @Autowired
    private WishListService wishListService;

    @Test
    public void searchTest(){
        var result = wishListService.search("미용실");
        System.out.println(result);
        Assertions.assertNotNull(result);

    }
}
