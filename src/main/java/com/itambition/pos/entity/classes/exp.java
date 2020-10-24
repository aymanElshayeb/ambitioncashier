package com.itambition.pos.entity.classes;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class exp {
    public int item_id;
    public String name;
    public long barcode;
    public float price;
    public int quantity;
    public String subCategory;

    public String name_cat;
    public exp(String name, long barcode, float price, int quantity, String sub, String cat){
        this.name=name;
        this.barcode=barcode;
        this.price=price;
        this.quantity=quantity;
        this.subCategory=sub;
        this.name_cat=cat;
    }
}
