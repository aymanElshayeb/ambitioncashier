package com.ITAmbition.Version1.Repository;

import com.ITAmbition.Version1.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity,Integer> {
}
