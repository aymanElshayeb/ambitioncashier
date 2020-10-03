package com.itambition.pos.repository;

import com.itambition.pos.entity.OrderEnitiy;
import com.itambition.pos.entity.OrderID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<OrderEnitiy, OrderID> {

    @Query("from OrderEnitiy where order_id.order_id = ?1")
    List<OrderEnitiy> findByorder_id(int order_id);

}
