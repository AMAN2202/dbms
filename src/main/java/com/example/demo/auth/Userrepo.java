package com.example.demo.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Userrepo {

    // we are autowiring jdbc template,
    // using the properties we have configured spring automatically
    // detects and creates jdbc template using the configuration
    @Autowired
    JdbcTemplate jdbcTemplate;


    public void addUser(User u) {
        String sql = "insert into user values(?,?,?)";
        int result = jdbcTemplate.update(sql, u.getPassword(), u.getUsername(), u.getType());
    }


}
