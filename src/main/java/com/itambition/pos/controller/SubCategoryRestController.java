package com.itambition.pos.controller;


import com.itambition.pos.entity.ItemEnitiy;
import com.itambition.pos.entity.SubCategoryEntity;
import com.itambition.pos.repository.SubCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubCategoryRestController {

    @Autowired
    private SubCategoryRepo SCRepo;


    @GetMapping("/subcategory")
    List<SubCategoryEntity> all(){
        return SCRepo.findAll();
    }

    @PostMapping("/subcategory")
    SubCategoryEntity newItem(@RequestBody SubCategoryEntity e) {
        return SCRepo.save(e);

    }

    @GetMapping("/subcategory/{id}")
    Optional<SubCategoryEntity> getOneItem(@PathVariable int path){

        return SCRepo.findById(path);
    }

    @DeleteMapping("/subcategory/{id}")
    void deleteItem(@PathVariable int path){
        SCRepo.deleteById(path);
    }

    @PutMapping("/subcategory/{id}")
    SubCategoryEntity editItem(@RequestBody SubCategoryEntity e,@PathVariable int path){


        return SCRepo.findById(path)
                .map(cat-> {
                    cat.setName(e.getName());
                    cat.setCategory(e.getCategory());

                    return SCRepo.save(cat);
                })
                .orElseGet(() -> {
                    e.setSubCategory_id(path);
                    return SCRepo.save(e);
                });


    }



}
