package com.itambition.pos.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderPageController {


    @GetMapping("/OrderPage")
    public String OrderPage(){return "orderpage";}
}
