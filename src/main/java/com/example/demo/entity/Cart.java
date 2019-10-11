package com.example.demo.entity;

//
//@Entity
//@Table
public class Cart {

    int customer_id;
    int item_id;
    int quantity;
    Item i;
    public Cart(int customer_id, int item_id, int quantity) {
        this.customer_id = customer_id;
        this.item_id = item_id;
        this.quantity = quantity;
    }

    public Cart() {
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getI() {
        return i;
    }

    public void setI(Item i) {
        this.i = i;
    }
}
