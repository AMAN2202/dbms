package com.example.demo.entity;

//@Entity
//@Table
public class Supplier {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    int supplier_id;
    int person_id;
    Personal_info p;


    public Supplier(int person_id, String username) {
        this.person_id = person_id;

    }

    public Supplier() {
    }

    public Supplier(int person_id, Personal_info p) {
        this.person_id = person_id;
        this.p = p;
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

    public Personal_info getP() {
        return p;
    }

    public void setP(Personal_info p) {
        this.p = p;
    }
}
