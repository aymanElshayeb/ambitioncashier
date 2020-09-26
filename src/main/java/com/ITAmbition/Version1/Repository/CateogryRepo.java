package com.ITAmbition.Version1.Repository;

import com.ITAmbition.Version1.Entity.CateogryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateogryRepo extends JpaRepository<CateogryEntity,Integer> {
}
