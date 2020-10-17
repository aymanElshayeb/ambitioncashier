package com.itambition.pos.repository;

import com.itambition.pos.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItemEntity, Integer> {
    @Query("from OrderItemEntity where orderEnitiy.order_id = ?1")
    List<OrderItemEntity> findByorder_id(int order_id);

}
