package com.example.demo.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

// can be updated
@Entity
@Table
public class Personal_info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int person_id;
    @NotNull
    @Column(unique = true)
    String email;
    @NotNull
    String Gender;
    @NotNull
    String firstname;
    @NotNull
    String lastname;
    @NotNull
    String zipcode;
    @NotNull
    String address;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    Date dob;
    String adharno;
    @NotNull
    @Column(unique = true)
    String phoneno;

    public Personal_info(@NotNull String email, @NotNull String gender, @NotNull String firstname, @NotNull String lastname, @NotNull String zipcode, @NotNull String address, @NotNull Date dob, String adharno, @NotNull String phoneno) {
        this.email = email;
        Gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
        this.zipcode = zipcode;
        this.address = address;
        this.dob = dob;
        this.adharno = adharno;
        this.phoneno = phoneno;
    }

    public Personal_info() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAdharno() {
        return adharno;
    }

    public void setAdharno(String adharno) {
        this.adharno = adharno;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }
}
