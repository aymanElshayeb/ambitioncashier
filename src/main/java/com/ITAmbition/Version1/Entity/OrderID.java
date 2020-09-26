package com.ITAmbition.Version1.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class OrderID implements Serializable {
    int order_id;
    int item_id;

//    public OrderID() {
//    }
//
//    public OrderID(int order_id, int item_id) {
//        this.order_id = order_id;
//        this.item_id = item_id;
//    }
}
