package com.itambition.pos.controller;


import com.itambition.pos.entity.ItemEnitiy;
import com.itambition.pos.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
public class OrderRestController {

    @Autowired
    ItemRepo itemRepo;

    @PostMapping("/AddOrderItem")
    void addToOrder(@RequestBody int quantity, @RequestBody int parcode, HttpServletRequest request){
        List<SessionObj> OrderItems= (List<SessionObj>) request.getSession().getAttribute("orderItems");
        SessionObj item=new SessionObj(quantity,parcode);
        boolean incremented=false;
        for (SessionObj x :OrderItems
             ) {
            if(x.parcode==parcode){

                x.quantity++;
            incremented=true;}


        }

        if (!incremented){
            OrderItems.add(item);}
            request.getSession().setAttribute("orderItems",OrderItems);

//add to session
    }

    @PostMapping("/RemoveOrderItem")
    void removeFromOrder(@RequestBody int parcode,HttpSession session){
        List<SessionObj> OrderItems = (List<SessionObj>) session.getAttribute("orderItem");
        for (SessionObj x:OrderItems
             ) {
            if (x.parcode==parcode&&x.quantity==1)
            {OrderItems.remove(x);
            break;} else if (x.parcode==parcode&&x.quantity>1){
                x.quantity--;
            }



        }

        session.setAttribute("orderItems",OrderItems);
        //remove from session
    }


    @GetMapping("/GetOrderItems")
    List<ItemEnitiy> getOrderItems(HttpSession session){
        List<SessionObj> OrderItems= (List<SessionObj>) session.getAttribute("orderItem");
        List<ItemEnitiy> temp=new ArrayList<ItemEnitiy>() ;
        for (SessionObj x:OrderItems
             ) {
            temp.add(itemRepo.findById(x.parcode).get());

        }

        return temp;
//from session
    }

    @GetMapping
    void checkout(){}




}
