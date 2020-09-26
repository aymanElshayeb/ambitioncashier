//package com.ITAmbition.Version1.Entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//@Table(name = "Cash")
//public class CashEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int cash_id;
//    @Column(nullable = false)
//    private long total_amount;
//    @Column(nullable = false)
//    private long amount_recieved;
//    @Column(nullable = false)
//    private long balance_due;
//    @Column(nullable = false)
//    private int order_id;
//
//
////
////    public CashEntity(int cash_id, long total_amount, long amount_recieved, long balance_due) {
////        this.cash_id = cash_id;
////        this.total_amount = total_amount;
////        this.amount_recieved = amount_recieved;
////        this.balance_due = balance_due;
////    }
////
////    public CashEntity() {
////    }
////
////    public int getCash_id() {
////        return cash_id;
////    }
////
////    public void setCash_id(int cash_id) {
////        this.cash_id = cash_id;
////    }
////
////    public long getTotal_amount() {
////        return total_amount;
////    }
////
////    public void setTotal_amount(long total_amount) {
////        this.total_amount = total_amount;
////    }
////
////    public long getAmount_recieved() {
////        return amount_recieved;
////    }
////
////    public void setAmount_recieved(long amount_recieved) {
////        this.amount_recieved = amount_recieved;
////    }
////
////    public long getBalance_due() {
////        return balance_due;
////    }
////
////    public void setBalance_due(long balance_due) {
////        this.balance_due = balance_due;
////    }
//}
