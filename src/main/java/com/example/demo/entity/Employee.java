package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int employee_id;


    String username;
    @NotNull
    int person_id;
    @NotNull
    int salary;
    @NotNull
    int balance;


    public Employee(String username, @NotNull int person_id, @NotNull int salary, @NotNull int balance) {
        this.username = username;
        this.person_id = person_id;
        this.salary = salary;
        this.balance = balance;
    }

    public Employee() {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getUsernaqme() {
        return username;
    }

    public void setUsernaqme(String usernaqme) {
        this.username = usernaqme;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
