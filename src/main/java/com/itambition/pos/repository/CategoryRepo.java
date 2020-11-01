package com.itambition.pos.repository;

import com.itambition.pos.entity.CategoryEntity;
import com.itambition.pos.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, UUID> {
    @Query("from CategoryEntity where name = ?1")
    CategoryEntity findByName(String name);
}
