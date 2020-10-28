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
}
