package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
public class Income_tax {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int income_tax_id;
    int penality;
    @NotNull
    int amount;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Date date;

    public Income_tax(int penality, @NotNull int amount, Date date) {
        this.penality = penality;
        this.amount = amount;
        this.date = date;
    }

    public Income_tax() {
    }

    public int getIncome_tax_id() {
        return income_tax_id;
    }

    public void setIncome_tax_id(int income_tax_id) {
        this.income_tax_id = income_tax_id;
    }

    public int getPenality() {
        return penality;
    }

    public void setPenality(int penality) {
        this.penality = penality;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
