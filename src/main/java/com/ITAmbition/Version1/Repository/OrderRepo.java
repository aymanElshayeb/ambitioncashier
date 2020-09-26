package com.ITAmbition.Version1.Repository;

import com.ITAmbition.Version1.Entity.OrderEnitiy;
import com.ITAmbition.Version1.Entity.OrderID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderEnitiy, OrderID> {
}
