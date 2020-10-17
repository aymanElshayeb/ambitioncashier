package com.itambition.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@Entity
@Table(name="Orders")
public class OrderEnitiy {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;
    @Column(nullable = false)
    private Timestamp dateTime;
    @Column(nullable = false)
    private long total_price;


    public OrderEnitiy(int order_id , Timestamp dateTime,long total_price) {
        this.order_id = order_id;
        this.dateTime = dateTime;
        this.total_price = total_price;
    }
    public OrderEnitiy() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

