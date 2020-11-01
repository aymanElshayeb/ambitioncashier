package com.itambition.pos.service;

import com.itambition.pos.entity.CategoryEntity;
import com.itambition.pos.entity.SubCategoryEntity;
import com.itambition.pos.repository.ItemRepo;
import com.itambition.pos.entity.ItemEnitiy;
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
    public List<ItemEnitiy> nostock() {
        return itemRepo.Noinstock();
    }

    public ItemEnitiy update(long Oldbarcode,long Newbarcode, String name, float price, int quantity, SubCategoryEntity subCategory) {
        ItemEnitiy itemEnitiy = itemRepo.findByBarcode(Oldbarcode);

        itemEnitiy.setBarcode(Newbarcode);
        itemEnitiy.setName(name);
        itemEnitiy.setPrice(price);
        itemEnitiy.setQuantity(quantity);
        itemEnitiy.setSubCategory(subCategory);

        return itemRepo.save(itemEnitiy);
    }


    public void deleteAll() {
        itemRepo.deleteAll();
    }

    public void delete(long barcode) {
        ItemEnitiy itemEnitiy = itemRepo.findByBarcode(barcode);
        itemRepo.delete(itemEnitiy);
    }
}
