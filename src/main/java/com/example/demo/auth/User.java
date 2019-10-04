package com.example.demo.auth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
    String type;
    @Id
    private String username;
    private String password;
    int active;
    String recovery_code;

    public User(String type, String username, String password, int active, String recovery_code) {
        this.type = type;
        this.username = username;
        this.password = password;
        this.active = active;
        this.recovery_code = recovery_code;
    }

    public User() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getRecovery_code() {
        return recovery_code;
    }

    public void setRecovery_code(String recovery_code) {
        this.recovery_code = recovery_code;
    }
}
