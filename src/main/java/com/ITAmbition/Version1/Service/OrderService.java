package com.ITAmbition.Version1.Service;

import com.ITAmbition.Version1.Entity.ItemEnitiy;
import com.ITAmbition.Version1.Entity.OrderEnitiy;
import com.ITAmbition.Version1.Entity.OrderID;
import com.ITAmbition.Version1.Repository.ItemRepo;
import com.ITAmbition.Version1.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    public List<OrderEnitiy> getAllitems() {
        List<OrderEnitiy> orders = new ArrayList<OrderEnitiy>();
        orderRepo.findAll().forEach(orders::add);
        return orders;
    }

    public OrderEnitiy getItem(OrderID id) {
        return orderRepo.findById(id).get();
    }

    public void addItem(OrderEnitiy category) {
        orderRepo.save(category);
    }

    public void updateCategory(String id, OrderEnitiy category) {
        orderRepo.save(category);
    }

    public void deleteCategory(OrderID id) {
        orderRepo.deleteById(id);
    }
}
