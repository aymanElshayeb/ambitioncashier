package com.itambition.pos.service;

import com.itambition.pos.repository.OrderRepo;
import com.itambition.pos.entity.OrderEnitiy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    public List<OrderEnitiy> getAllorders() {
        List<OrderEnitiy> orders = new ArrayList<OrderEnitiy>();
        orderRepo.findAll().forEach(orders::add);
        return orders;
    }

    public OrderEnitiy getOrder(int id) {
        return orderRepo.findById(id).get();
    }

//    public List<OrderEnitiy> getOrder(int id) {
//        List<OrderEnitiy> orders = new ArrayList<OrderEnitiy>();
//        orderRepo.findByorder_id(id).forEach(orders::add);
//        return orders;
//    }

    public void addOrder(OrderEnitiy category) {
        orderRepo.save(category);
    }

    public void updateOrder(String id, OrderEnitiy category) {
        orderRepo.save(category);
    }

    public void deleteOrder(int id) {
        orderRepo.deleteById(id);
    }
}
