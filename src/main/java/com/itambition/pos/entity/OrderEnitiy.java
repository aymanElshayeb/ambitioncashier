package com.itambition.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Orders")
public class OrderEnitiy {
    @EmbeddedId()
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private OrderID order_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private long barcode;
    @Column(nullable = false)
    private Timestamp dateTime;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private long unit_price;
    @Column(nullable = false)
    private long total_price;



    //    public OrderEnitiy(int order_id, long item_id, String name, long barcode, Timestamp dateTime, int quantity, long unit_price, long total_price) {
//        this.order_id = order_id;
//        this.item_id = item_id;
//        this.name = name;
//        this.barcode = barcode;
//        this.dateTime = dateTime;
//        this.quantity = quantity;
//        this.unit_price = unit_price;
//        this.total_price = total_price;
//    }
//
//    public OrderEnitiy() {
//    }
//
//    public int getOrder_id() {
//        return order_id;
//    }
//
//    public void setOrder_id(int order_id) {
//        this.order_id = order_id;
//    }
//
//    public long getItem_id() {
//        return item_id;
//    }
//
//    public void setItem_id(long item_id) {
//        this.item_id = item_id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public long getBarcode() {
//        return barcode;
//    }
//
//    public void setBarcode(long barcode) {
//        this.barcode = barcode;
//    }
//
//    public Timestamp getDateTime() {
//        return dateTime;
//    }
//
//    public void setDateTime(Timestamp dateTime) {
//        this.dateTime = dateTime;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public long getUnit_price() {
//        return unit_price;
//    }
//
//    public void setUnit_price(long unit_price) {
//        this.unit_price = unit_price;
//    }
//
//    public long getTotal_price() {
//        return total_price;
//    }
//
//    public void setTotal_price(long total_price) {
//        this.total_price = total_price;
//    }
}

