package com.ITAmbition.Version1.Service;

import com.ITAmbition.Version1.Entity.CategoryEntity;
import com.ITAmbition.Version1.Entity.SubCategoryEntity;
import com.ITAmbition.Version1.Repository.CategoryRepo;
import com.ITAmbition.Version1.Repository.SubCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryService {

    @Autowired
    SubCategoryRepo subCategoryRepo;

    public List<SubCategoryEntity> getAllcategories() {
        List<SubCategoryEntity> subcategories = new ArrayList<SubCategoryEntity>();
        subCategoryRepo.findAll().forEach(subcategories::add);
        return subcategories;
    }

    public SubCategoryEntity getSubCategory(int id) {
        return subCategoryRepo.findById(id).get();
    }

    public void addSubCategory(SubCategoryEntity subcategory) {
        subCategoryRepo.save(subcategory);
    }

    public void updateSubCategory(String id, SubCategoryEntity subcategory) {
        subCategoryRepo.save(subcategory);
    }

    public void deleteSubCategory(int id) {
        subCategoryRepo.deleteById(id);
    }
}
