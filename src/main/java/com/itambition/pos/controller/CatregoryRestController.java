package com.itambition.pos.controller;

import com.itambition.pos.entity.CategoryEntity;
import com.itambition.pos.repository.CategoryRepo;
import com.itambition.pos.service.Categoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatregoryRestController {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private Categoryservice categoryservice;

    @CachePut(value="categories",key="#name")
    @RequestMapping("/createCatregory")
    @ResponseBody
    public CategoryEntity create(@RequestParam String name) {
        System.out.println("Creating record Category");
        //should check in db before inserintg
        return categoryRepo.save(new CategoryEntity(name));
    }

    @Cacheable(value= "categories",key="#name")
    @RequestMapping("/getCatregory")
    @ResponseBody
    public CategoryEntity getCategory(@RequestParam String name) {
        System.out.println("Getting record Category");
        //check if the name exist ot not

        return categoryRepo.findByName(name);
    }
    @CachePut(value= "categories")
    @RequestMapping("/getAllCategories")
    @ResponseBody
    public List<CategoryEntity> getAll(){
        System.out.println("Getting all records categories");
        return categoryservice.getAllcategories();
    }

    @CachePut(value="categories",key="#name")
    @RequestMapping("/updateCategory")
    @ResponseBody
    public CategoryEntity update(@RequestParam String name , @RequestParam String newName) {
        System.out.println("Updating record Category");
        //check if the new name exist ot not
        return categoryservice.update(name,newName);
    }

    @CacheEvict(value="categories",key="#name")
    @RequestMapping("/deleteCategory")
    public String delete(@RequestParam String name) {
        System.out.println("Deleting record Category");
        //check if the name exist ot not
        categoryservice.delete(name);
        return "Deleted "+ name;
    }
    @CacheEvict(value="categories",allEntries=true)
    @RequestMapping("/deleteAllCategories")
    public String deleteAll() {
        System.out.println("Deleting all records Categories");
        categoryservice.deleteAll();
        return "Deleted all records Categories ";
    }
}
