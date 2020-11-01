package com.itambition.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
@Entity
@Table(name = "Categories")
public class CategoryEntity implements Serializable {
    @Id
    @GeneratedValue
//    @GeneratedValue(generator = UUID)
    private UUID category_id;
    @Column(nullable = false,unique=true)
    private String name;

    public CategoryEntity(UUID category_id, String name) {
        this.category_id = category_id;
        this.name = name;
    }
    public CategoryEntity( String name) {
        this.name = name;
    }
    public CategoryEntity() {
    }

    public UUID getCategory_id() {
        return category_id;
    }

    public void setCategory_id(UUID category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
