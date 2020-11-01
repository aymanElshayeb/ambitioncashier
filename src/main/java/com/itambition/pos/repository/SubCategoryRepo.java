package com.itambition.pos.repository;
import com.itambition.pos.entity.CategoryEntity;
import com.itambition.pos.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategoryEntity, UUID>{
    @Query("from SubCategoryEntity where name = ?1")
    SubCategoryEntity findByName(String name);

    @Query("from SubCategoryEntity where category = ?1")
    List<SubCategoryEntity> findAllByCategory(CategoryEntity name);


}
