package com.ITAmbition.Version1.Repository;

import com.ITAmbition.Version1.Entity.ItemEnitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<ItemEnitiy,Integer> {
    @Query("FROM ItemEnitiy WHERE item_id=?1 ")
    List <ItemEnitiy>findbyiddd(int id);
}
