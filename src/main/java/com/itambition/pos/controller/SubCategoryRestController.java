package com.itambition.pos.controller;

import com.itambition.pos.entity.CategoryEntity;
import com.itambition.pos.entity.SubCategoryEntity;
import com.itambition.pos.repository.CategoryRepo;
import com.itambition.pos.repository.SubCategoryRepo;
import com.itambition.pos.service.Categoryservice;
import com.itambition.pos.service.SubCategoryService;
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
public class SubCategoryRestController {
    @Autowired
    private SubCategoryRepo subCategoryRepo;
    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private CategoryRepo categoryRepo;

    @CachePut(value="subcategories",key="#name")
    @RequestMapping("/createSubCatregory")
    @ResponseBody
    public SubCategoryEntity create(@RequestParam String name , @RequestParam String categoryName ) {
        System.out.println("Creating record SubCategory");
        CategoryEntity categoryEntity = categoryRepo.findByName(categoryName);

        return subCategoryRepo.save(new SubCategoryEntity(name,categoryEntity));
    }

    @Cacheable(value= "subcategories",key="#name")
    @RequestMapping("/getSubCatregory")
    @ResponseBody
    public SubCategoryEntity getSubCategory(@RequestParam String name) {
        System.out.println("Getting record SubCategory");
        return subCategoryRepo.findByName(name);
    }

    @CachePut(value= "subcategories")
    @RequestMapping("/getAllSubCategories")
    @ResponseBody
    public List<SubCategoryEntity> getAll(){
        System.out.println("Getting all records Subcategories");
        return subCategoryService.getAllSubCategories();
    }

    @CachePut(value="subcategories",key="#name")
    @RequestMapping("/updateSubCategory")
    @ResponseBody
    public SubCategoryEntity update(@RequestParam String name , @RequestParam String newName,@RequestParam String categoryName) {
        System.out.println("Updating record SubCategory");
        CategoryEntity categoryEntity = categoryRepo.findByName(categoryName);

        return subCategoryService.update(name,newName,categoryEntity);
    }

    @CacheEvict(value="subcategories",key="#name")
    @RequestMapping("/deleteSubCategory")
    public String delete(@RequestParam String name) {
        System.out.println("Deleting record SubCategory");
        subCategoryService.delete(name);
        return "Deleted "+ name;
    }
    @CacheEvict(value="subcategories",allEntries=true)
    @RequestMapping("/deleteAllSubCategories")
    public String deleteAll() {
        System.out.println("Deleting all records SubCategories");
        subCategoryService.deleteAll();
        return "Deleted all records SubCategories ";
    }


}
