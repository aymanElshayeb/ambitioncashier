package com.itambition.pos.controller;


import com.itambition.pos.entity.ItemEnitiy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderRestController {

    @PostMapping("/AddOrderItem")
    void addToOrder(@RequestBody int quantity,@RequestBody long parcode){

//add to session
    }

    @PostMapping("/RemoveOrderItem")
    void removeFromOrder(@RequestBody long parcode){
        //remove from session
    }


    @GetMapping("/GetOrderItems")
    List<ItemEnitiy> getOrderItems(){
//from session
    }

    @GetMapping
    void checkout(){}




}
