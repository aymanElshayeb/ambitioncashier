package com.itambition.pos.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name="OrdersItems")
public class OrderItemEntity implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private long barcode;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private float unit_price;
    @Column(nullable = false)
    private long total_price;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private OrderEnitiy orderEnitiy;

    public OrderItemEntity() {
    }

    public OrderItemEntity(UUID id, String name, long barcode, int quantity, float unit_price, long total_price, OrderEnitiy orderEnitiy) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.total_price = total_price;
        this.orderEnitiy = orderEnitiy;
    }
    public OrderItemEntity(String name, long barcode, int quantity, float unit_price, long total_price, OrderEnitiy orderEnitiy) {
        this.name = name;
        this.barcode = barcode;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.total_price = total_price;
        this.orderEnitiy = orderEnitiy;
    }
    public UUID getId() {
        return id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(long total_price) {
        this.total_price = total_price;
    }

    public OrderEnitiy getOrderEnitiy() {
        return orderEnitiy;
    }

    public void setOrderEnitiy(OrderEnitiy orderEnitiy) {
        this.orderEnitiy = orderEnitiy;
    }
}
