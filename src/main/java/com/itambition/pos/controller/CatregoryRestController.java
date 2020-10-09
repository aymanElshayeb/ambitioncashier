package com.itambition.pos.controller;


import com.itambition.pos.entity.CategoryEntity;
import com.itambition.pos.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CatregoryRestController {

    @Autowired
    private CategoryRepo categoryRepo;


    @GetMapping("/category")
    List<CategoryEntity> all(){
        return categoryRepo.findAll();
    }

    @PostMapping("/category")
    CategoryEntity newItem(@RequestBody CategoryEntity e) {
        return categoryRepo.save(e);

    }

    @GetMapping("/category/{id}")
    Optional<CategoryEntity> getOneItem(@PathVariable int path){

        return categoryRepo.findById(path);
    }

    @DeleteMapping("/category/{id}")
    void deleteItem(@PathVariable int path){
        categoryRepo.deleteById(path);
    }

    @PutMapping("/category/{id}")
    CategoryEntity editItem(@RequestBody CategoryEntity e,@PathVariable int path) throws ClassNotFoundException {


        return categoryRepo.findById(path)
                .map(cat-> {
                    cat.setName(e.getName());

                    return categoryRepo.save(cat);
                })
                .orElseGet(() -> {
                    e.setCategory_id(path);
                    return categoryRepo.save(e);
                });

    }

}
