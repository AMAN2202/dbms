package com.example.demo.entity;

public class ItemFilter {
    int brand_id;
    String name;
    int min_p;
    int max_p;
    int rating;


    public ItemFilter(int brand_id, String name, int min_p, int max_p, int rating) {
        this.brand_id = brand_id;
        this.name = name;
        this.min_p = min_p;
        this.max_p = max_p;
        this.rating = rating;
    }

    public ItemFilter() {
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMin_p() {
        return min_p;
    }

    public void setMin_p(int min_p) {
        this.min_p = min_p;
    }

    public int getMax_p() {
        return max_p;
    }

    public void setMax_p(int max_p) {
        this.max_p = max_p;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
