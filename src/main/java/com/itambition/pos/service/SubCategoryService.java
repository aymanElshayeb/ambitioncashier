package com.itambition.pos.service;

import com.itambition.pos.entity.CategoryEntity;
import com.itambition.pos.repository.SubCategoryRepo;
import com.itambition.pos.entity.SubCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryService {

    @Autowired
    SubCategoryRepo subCategoryRepo;

    public List<SubCategoryEntity> getAllSubCategories() {
        List<SubCategoryEntity> subcategories = new ArrayList<SubCategoryEntity>();
        subCategoryRepo.findAll().forEach(subcategories::add);
        return subcategories;
    }

    public SubCategoryEntity update(String name , String Newname , CategoryEntity Newcategory ) {
        SubCategoryEntity subCategoryEntity  = subCategoryRepo.findByName(name);
        subCategoryEntity.setName(Newname);
        subCategoryEntity.setCategory(Newcategory);
        return subCategoryRepo.save(subCategoryEntity);
    }

    public void deleteAll() {
        subCategoryRepo.deleteAll();
    }

    public void delete(String name) {
        SubCategoryEntity subCategoryEntity = subCategoryRepo.findByName(name);
        subCategoryRepo.delete(subCategoryEntity);
    }
}
