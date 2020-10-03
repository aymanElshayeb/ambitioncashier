package com.ITAmbition.Version1.Service;

import com.ITAmbition.Version1.Entity.ItemEnitiy;
import com.ITAmbition.Version1.Entity.OrderEnitiy;
import com.ITAmbition.Version1.Entity.OrderID;
import com.ITAmbition.Version1.Repository.ItemRepo;
import com.ITAmbition.Version1.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
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

    public OrderEnitiy getOrder(OrderID id) {
        return orderRepo.findById(id).get();
    }

    public List<OrderEnitiy> getOrder(int id) {
        List<OrderEnitiy> orders = new ArrayList<OrderEnitiy>();
        orderRepo.findByorder_id(id).forEach(orders::add);
        return orders;
    }

    public void addOrder(OrderEnitiy category) {
        orderRepo.save(category);
    }

    public void updateOrder(String id, OrderEnitiy category) {
        orderRepo.save(category);
    }

    public void deleteOrder(OrderID id) {
        orderRepo.deleteById(id);
    }
}
