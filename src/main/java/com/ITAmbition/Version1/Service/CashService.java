//package com.ITAmbition.Version1.Service;
//
//import com.ITAmbition.Version1.Entity.CashEntity;
//import com.ITAmbition.Version1.Entity.ItemEnitiy;
//import com.ITAmbition.Version1.Repository.CashRepo;
//import com.ITAmbition.Version1.Repository.ItemRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//@Service
//public class CashService {
//
//    @Autowired
//    CashRepo cashRepo;
//
//    public List<CashEntity> getAllitems() {
//        List<CashEntity> items = new ArrayList<CashEntity>();
//        cashRepo.findAll().forEach(items::add);
//        return items;
//    }
//
//    public CashEntity getItem(int id) {
//        return cashRepo.findById(id).get();
//    }
//
//    public void addItem(CashEntity category) {
//        cashRepo.save(category);
//    }
//
//    public void updateCategory(String id, CashEntity category) {
//        cashRepo.save(category);
//    }
//
//    public void deleteCategory(int id) {
//        cashRepo.deleteById(id);
//    }
//}
