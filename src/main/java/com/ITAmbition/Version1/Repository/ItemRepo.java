package com.ITAmbition.Version1.Repository;

import com.ITAmbition.Version1.Entity.ItemEnitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<ItemEnitiy,Integer> {
}
