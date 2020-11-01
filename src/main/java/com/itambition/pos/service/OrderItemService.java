package com.itambition.pos.service;

import com.itambition.pos.entity.OrderItemEntity;
import com.itambition.pos.repository.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    OrderItemRepo orderItemRepo;

    public List<OrderItemEntity> getAllitems(int id) {
        List<OrderItemEntity> items = new ArrayList<OrderItemEntity>();
        orderItemRepo.findByorder_id(id).forEach(items::add);
        return items;
    }

    public List<OrderItemEntity> getAllitems() {
        List<OrderItemEntity> items = new ArrayList<OrderItemEntity>();
        orderItemRepo.findAll().forEach(items::add);
        return items;
    }


}
