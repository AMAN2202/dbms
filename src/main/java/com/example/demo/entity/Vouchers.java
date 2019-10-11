package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "voucher")
public class Vouchers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int voucher_id;
    @NotNull
    int credits;
    int active;

    int customerid;

    public Vouchers(@NotNull int credits, int customerid) {
        this.credits = credits;
        this.customerid = customerid;
    }

    public Vouchers() {
    }

    public int getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(int voucher_id) {
        this.voucher_id = voucher_id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
