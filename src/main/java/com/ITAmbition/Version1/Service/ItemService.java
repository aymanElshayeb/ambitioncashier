package com.ITAmbition.Version1.Service;

import com.ITAmbition.Version1.Entity.CategoryEntity;
import com.ITAmbition.Version1.Entity.ItemEnitiy;
import com.ITAmbition.Version1.Repository.CategoryRepo;
import com.ITAmbition.Version1.Repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepo itemRepo;

    public List<ItemEnitiy> getAllitems() {
        List<ItemEnitiy> items = new ArrayList<ItemEnitiy>();
        itemRepo.findAll().forEach(items::add);
        return items;
    }

    public ItemEnitiy getItem(int id) {
        return itemRepo.findById(id).get();
    }

    public void addItem(ItemEnitiy category) {
        itemRepo.save(category);
    }

    public void updateCategory(String id, ItemEnitiy category) {
        itemRepo.save(category);
    }

    public void deleteCategory(int id) {
        itemRepo.deleteById(id);
    }

}
