package com.itambition.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
//@Builder
@Entity
@Table(name = "SubCategories")

public class SubCategoryEntity implements Serializable {
    @Id
    @GeneratedValue
    private UUID subCategory_id;
    @Column(nullable = false,unique=true)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public SubCategoryEntity() {}

    public SubCategoryEntity(String name, CategoryEntity category) {
        this.name = name;
        this.category = category;
    }

    public UUID getSubCategory_id() {return subCategory_id; }

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
