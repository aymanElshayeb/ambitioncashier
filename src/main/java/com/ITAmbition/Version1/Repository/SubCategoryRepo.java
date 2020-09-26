package com.ITAmbition.Version1.Repository;
import com.ITAmbition.Version1.Entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategoryEntity,Integer>{

}
