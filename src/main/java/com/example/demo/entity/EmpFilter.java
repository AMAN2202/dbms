package com.example.demo.entity;

public class EmpFilter {
    Personal_info p;
    Employee e;
    int age;

    public EmpFilter(Personal_info p, Employee e) {
        this.p = p;
        this.e = e;
    }

    public EmpFilter() {
    }

    public Personal_info getP() {
        return p;
    }

    public void setP(Personal_info p) {
        this.p = p;
    }

    public Employee getE() {
        return e;
    }

    public void setE(Employee e) {
        this.e = e;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
