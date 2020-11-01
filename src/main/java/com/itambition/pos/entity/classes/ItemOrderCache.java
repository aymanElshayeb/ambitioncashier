package com.itambition.pos.entity.classes;
import javax.persistence.Column;
import java.io.Serializable;

public class ItemOrderCache implements Serializable {
    private long barcode;
    private int quantity;

    public ItemOrderCache() {
    }
    public ItemOrderCache(long barcode, int quantity) {
        this.barcode = barcode;
        this.quantity = quantity;
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
}
