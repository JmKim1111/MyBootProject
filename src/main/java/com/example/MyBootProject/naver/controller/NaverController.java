package com.example.MyBootProject.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class NaverController {

    @GetMapping("/NaverUI")
    public ModelAndView main(){
        return new ModelAndView("/NaverUI");
    }
}
