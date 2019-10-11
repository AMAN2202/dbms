package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
public class Reciept {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long receipt_id;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Date date;
    @NotNull
    int amount;
    int discount;
    @NotNull
    int amount_payed;
    int customer_id;

    public Reciept(Date date, @NotNull int amount, int discount, @NotNull int amount_payed, int customer_id) {
        this.date = date;
        this.amount = amount;
        this.discount = discount;
        this.amount_payed = amount_payed;
        this.customer_id = customer_id;
    }

    public Reciept() {
    }

    public long getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(long receipt_id) {
        this.receipt_id = receipt_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getAmount_payed() {
        return amount_payed;
    }

    public void setAmount_payed(int amount_payed) {
        this.amount_payed = amount_payed;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
