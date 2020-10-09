package com.itambition.pos.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddPageController {


    @GetMapping("/add")
    public String AddPage(){
        return "addpage";
    }
}
