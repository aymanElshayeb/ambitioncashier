package com.itambition.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SubCategories")

public class SubCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subCategory_id;
    @Column(nullable = false)
    private String name;

//    fetch = FetchType.LAZY, optional = false
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public SubCategoryEntity() {
    }

    public SubCategoryEntity(int subCategory_id, String name, CategoryEntity category) {
        this.subCategory_id = subCategory_id;
        this.name = name;
        this.category = category;
    }

    public int getSubCategory_id() {
        return subCategory_id;
    }

    public void setSubCategory_id(int subCategory_id) {
        this.subCategory_id = subCategory_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
