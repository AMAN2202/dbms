package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Item {
    @Id
    public int item_id;
    public String name;
    public int quantity_available;
    public int cost_price;
    public int mrp;
    public int brand_id;
    public int discount;
    public int voucher_credit;
    public String category;
    public String imgurl;


    public Item(int item_id, String name, int quantity_available, int cost_price, int mrp, int brand_id, int discount, int voucher_credit, String category, String imgurl) {
        this.item_id = item_id;
        this.name = name;
        this.quantity_available = quantity_available;
        this.cost_price = cost_price;
        this.mrp = mrp;
        this.brand_id = brand_id;
        this.discount = discount;
        this.voucher_credit = voucher_credit;
        this.category = category;
        this.imgurl = imgurl;
    }

    public Item() {
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }

    public int getCost_price() {
        return cost_price;
    }

    public void setCost_price(int cost_price) {
        this.cost_price = cost_price;
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getVoucher_credit() {
        return voucher_credit;
    }

    public void setVoucher_credit(int voucher_credit) {
        this.voucher_credit = voucher_credit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }


}
