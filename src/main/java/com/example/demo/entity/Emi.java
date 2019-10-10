package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table
public class Emi {
    @Id
    int emi_id;
    int customer_id;
    @Column(nullable = true)
    int item_id;
    int pending;
    int paid_fraction;
    int tot_fraction;
    int principal;
    double Intrest;
    Date date;

    public Emi(int emi_id, int customer_id, int item_id, int pending, int paid_fraction, int tot_fraction, int principal, double intrest, Date date) {
        this.emi_id = emi_id;
        this.customer_id = customer_id;
        this.item_id = item_id;
        this.pending = pending;
        this.paid_fraction = paid_fraction;
        this.tot_fraction = tot_fraction;
        this.principal = principal;
        Intrest = intrest;
        this.date = date;
    }

    public Emi() {
    }

    public int getEmi_id() {
        return emi_id;
    }

    public void setEmi_id(int emi_id) {
        this.emi_id = emi_id;
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

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    public int getPaid_fraction() {
        return paid_fraction;
    }

    public void setPaid_fraction(int paid_fraction) {
        this.paid_fraction = paid_fraction;
    }

    public int getTot_fraction() {
        return tot_fraction;
    }

    public void setTot_fraction(int tot_fraction) {
        this.tot_fraction = tot_fraction;
    }

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public double getIntrest() {
        return Intrest;
    }

    public void setIntrest(double intrest) {
        Intrest = intrest;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
