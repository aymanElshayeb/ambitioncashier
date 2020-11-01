package com.itambition.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "Items")
public class ItemEnitiy implements Serializable {
    @Id
    @GeneratedValue
    private UUID item_id;
    @Column(nullable = false,unique=true)
    private String name;
    @Column(nullable = false,unique=true)
    private long barcode;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false)
    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "subCategory_id")
    private SubCategoryEntity subCategory;

    public ItemEnitiy() {
    }

    public ItemEnitiy(UUID item_id, String name, long barcode, float price, int quantity, SubCategoryEntity subCategory) {
        this.item_id = item_id;
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
        this.subCategory = subCategory;
    }

    public ItemEnitiy(String name, long barcode, float price, int quantity, SubCategoryEntity subCategory) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
        this.subCategory = subCategory;
    }

    public UUID getItem_id() {
        return item_id;
    }

    public void setItem_id(UUID item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SubCategoryEntity getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategoryEntity subCategory) {
        this.subCategory = subCategory;
    }
}
