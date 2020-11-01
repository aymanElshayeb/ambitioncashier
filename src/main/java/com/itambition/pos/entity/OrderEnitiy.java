package com.itambition.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name="Orders")
public class OrderEnitiy implements Serializable {
    @Id
    @GeneratedValue
    private UUID order_id;
    @Column(nullable = false)
    private Timestamp dateTime;
    @Column(nullable = false)
    private long total_price;

    public OrderEnitiy() {
    }
    public OrderEnitiy(UUID order_id , Timestamp dateTime,long total_price) {
        this.order_id = order_id;
        this.dateTime = dateTime;
        this.total_price = total_price;
    }

    public OrderEnitiy(Timestamp dateTime,long total_price) {
        this.dateTime = dateTime;
        this.total_price = total_price;
    }
    public OrderEnitiy(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public UUID getOrder_id() {
        return order_id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(long total_price) {
        this.total_price = total_price;
    }
}

