package com.itambition.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder


@Entity
@Table(name = "Categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    @Column(nullable = false)

    private String name;


    public void setName(String name) {
        this.name = name;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    //    public CateogryEntity(int category_id, String name) {
//        this.category_id = category_id;
//        this.name = name;
//    }
//
//    public CateogryEntity() {
//    }
//
//    public int getCategory_id() {
//        return category_id;
//    }
//
//    public void setCategory_id(int category_id) {
//        this.category_id = category_id;
//    }
//
    public String getName() {
        return name;
    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
