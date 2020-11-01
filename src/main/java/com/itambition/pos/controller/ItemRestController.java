package com.itambition.pos.controller;

import com.itambition.pos.entity.CategoryEntity;
import com.itambition.pos.entity.ItemEnitiy;
import com.itambition.pos.entity.SubCategoryEntity;
import com.itambition.pos.repository.ItemRepo;
import com.itambition.pos.repository.SubCategoryRepo;
import com.itambition.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ItemRestController {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    ItemService itemService;
    @Autowired
    SubCategoryRepo subCategoryRepo;

    @CachePut(value="items",key="#barcode")
    @RequestMapping("/addItem")
    @ResponseBody
    public ItemEnitiy create(@RequestParam String name ,@RequestParam long barcode,@RequestParam float price,@RequestParam int quantity,@RequestParam String subCategory) {
        System.out.println("Creating record Item");
        SubCategoryEntity subCategoryEntity = subCategoryRepo.findByName(subCategory);

        return itemRepo.save(new ItemEnitiy(name,barcode,price,quantity,subCategoryEntity));
    }

    @Cacheable(value= "items",key="#barcode")
    @RequestMapping("/getItem")
    @ResponseBody
    public ItemEnitiy getItem(@RequestParam long barcode) {
        System.out.println("Getting record Item");
        return itemRepo.findByBarcode(barcode);
    }

    @CachePut(value= "items")
    @RequestMapping("/getAllItems")
    @ResponseBody
    public List<ItemEnitiy> getAll(){
        System.out.println("Getting all records Items");
        return itemService.getAllitems();
    }

    @CachePut(value="items",key="#barcode")
    @RequestMapping("/updateitem")
    @ResponseBody
    public ItemEnitiy update(@RequestParam long barcode ,@RequestParam long Newbarcode , @RequestParam String name , @RequestParam float price,@RequestParam int quantity,@RequestParam String subCategory) {
        System.out.println("Updating record Item");
        SubCategoryEntity subCategoryEntity = subCategoryRepo.findByName(subCategory);

        return itemService.update(barcode ,Newbarcode,name ,  price,quantity,subCategoryEntity);
    }

    @CacheEvict(value="items",key="#barcode")
    @RequestMapping("/deleteItem")
    public String delete(@RequestParam long barcode) {
        System.out.println("Deleting record Item");
        itemService.delete(barcode);
        return "Deleted "+ barcode;
    }
    @CacheEvict(value="items",allEntries=true)
    @RequestMapping("/deleteAllItems")
    public String deleteAll() {
        System.out.println("Deleting all records Items");
        itemService.deleteAll();
        return "Deleted all records Items ";
    }

}
