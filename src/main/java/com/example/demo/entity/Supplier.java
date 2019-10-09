package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int supplier_id;
    int person_id;


    public Supplier(int person_id, String username) {
        this.person_id = person_id;

    }

    public Supplier() {
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

}
