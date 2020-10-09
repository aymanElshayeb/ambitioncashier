package com.itambition.pos.controller;

import com.itambition.pos.entity.ItemEnitiy;
import com.itambition.pos.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemRestController {

    @Autowired
    private  ItemRepo itemRepo ;

    @GetMapping("/items")
    List<ItemEnitiy> all(){
        return itemRepo.findAll();
    }

    @PostMapping("/items")
    ItemEnitiy newItem(@RequestBody ItemEnitiy e) {
        return itemRepo.save(e);

    }

    @GetMapping("/items/{id}")
    Optional<ItemEnitiy> getOneItem(@PathVariable int path){

        return itemRepo.findById(path);
    }

    @DeleteMapping("/items/{id}")
    void deleteItem(@PathVariable int path){
        itemRepo.deleteById(path);
    }

    @PutMapping("/items/{id}")
    ItemEnitiy editItem(@RequestBody ItemEnitiy e,@PathVariable int path){

        return itemRepo.findById(path)
                .map(item-> {
                    item.setName(e.getName());
                    item.setPrice(e.getPrice());
                    item.setBarcode(e.getBarcode());
                    item.setQuantity(e.getQuantity());
                    item.setSubCategory(e.getSubCategory());



                    return itemRepo.save(item);
                })
                .orElseGet(() -> {
                    e.setItem_id(path);
                    return itemRepo.save(e);
                });


    }


}
