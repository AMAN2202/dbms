package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Item {
    @Id
    int item_id;
    String name;
    int qt_avail;
    int cost_price;
    int mrp;
    int brand_id;
    int sold_qt;
    int rating;
    int discount;
    String category;
    String imgurl;
    String description;

    public Item(int item_id, String name, int qt_avail, int cost_price, int mrp, int brand_id, int sold_qt, int rating, int discount, int voucher_credit, String category, String imgurl, String description) {
        this.item_id = item_id;
        this.name = name;
        this.qt_avail = qt_avail;
        this.cost_price = cost_price;
        this.mrp = mrp;
        this.brand_id = brand_id;
        this.sold_qt = sold_qt;
        this.rating = rating;
        this.discount = discount;
        this.category = category;
        this.imgurl = imgurl;
        this.description = description;
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

    public int getQt_avail() {
        return qt_avail;
    }

    public void setQt_avail(int qt_avail) {
        this.qt_avail = qt_avail;
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

    public int getSold_qt() {
        return sold_qt;
    }

    public void setSold_qt(int sold_qt) {
        this.sold_qt = sold_qt;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
