package com.itambition.pos.repository;

import com.itambition.pos.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity,Integer> {
}
