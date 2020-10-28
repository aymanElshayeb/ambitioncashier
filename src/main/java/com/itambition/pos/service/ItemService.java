package com.itambition.pos.service;

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

}
