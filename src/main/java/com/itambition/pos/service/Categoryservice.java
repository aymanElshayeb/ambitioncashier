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

    public CategoryEntity getCategory(int id) {
        return categoryRepo.findById(id).get();
    }

    public void addCategory(CategoryEntity category) {
        categoryRepo.save(category);
    }

    public void updateCategory(String id, CategoryEntity category) {
        categoryRepo.save(category);
    }

    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }


}
