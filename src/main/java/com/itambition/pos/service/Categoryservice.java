package com.itambition.pos.service;

import com.itambition.pos.repository.CategoryRepo;
import com.itambition.pos.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Categoryservice {

    @Autowired
    CategoryRepo categoryRepo;

    public List<CategoryEntity> getAllcategories() {
        List<CategoryEntity> categories = new ArrayList<CategoryEntity>();
        categoryRepo.findAll().forEach(categories::add);
        return categories;
    }


    public CategoryEntity update(String name ,String Newname ) {
        CategoryEntity categoryEntity = categoryRepo.findByName(name);
        categoryEntity.setName(Newname);
        return categoryRepo.save(categoryEntity);
    }

    public void deleteAll() {
        categoryRepo.deleteAll();
    }

    public void delete(String name) {
        CategoryEntity categoryEntity = categoryRepo.findByName(name);
        categoryRepo.delete(categoryEntity);
    }
}
