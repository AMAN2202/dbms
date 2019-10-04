package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
public class Wages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int wage_id;
    @NotNull
    int amount;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Date date;
    int employee_id;

    public Wages(@NotNull int amount, Date date, int employee_id) {
        this.amount = amount;
        this.date = date;
        this.employee_id = employee_id;
    }

    public Wages() {
    }

    public int getWage_id() {
        return wage_id;
    }

    public void setWage_id(int wage_id) {
        this.wage_id = wage_id;
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

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }
}
