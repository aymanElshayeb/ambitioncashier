package com.itambition.pos.service;

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

    public List<SubCategoryEntity> getAllcategories() {
        List<SubCategoryEntity> subcategories = new ArrayList<SubCategoryEntity>();
        subCategoryRepo.findAll().forEach(subcategories::add);
        return subcategories;
    }
}
