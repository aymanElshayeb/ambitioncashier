package com.ITAmbition.Version1.Entity;

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
@Table(name = "Items")
public class ItemEnitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int item_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private long barcode;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false)
    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "subCategory_id")
    private SubCategoryEntity subCategory;

//    public ItemEnitiy(int item_id, String name, long barcode, float price, int quantity, SubCategoryEntity subCategory) {
//        this.item_id = item_id;
//        this.name = name;
//        this.barcode = barcode;
//        this.price = price;
//        this.quantity = quantity;
//        this.subCategory = subCategory;
//    }
//
//    public ItemEnitiy() {
//    }
//
    public int getItem_id() {
       return item_id;
    }
//
//    public void setItem_id(int item_id) {
//        this.item_id = item_id;
//    }
//
    public String getName() {
        return name;
    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
    public long getBarcode() {
        return barcode;
    }

//    public void setBarcode(long barcode) {
//        this.barcode = barcode;
//    }
//
    public float getPrice() {
        return price;
    }
//
//    public void setPrice(float price) {
//        this.price = price;
//    }
//
    public int getQuantity() {
        return quantity;
    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
   public SubCategoryEntity getSubCategory() {
        return subCategory;
    }
//
//    public void setSubCategory(SubCategoryEntity subCategory) {
//        this.subCategory = subCategory;
//    }
}
