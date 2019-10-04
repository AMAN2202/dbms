package com.example.rowmapper;

import com.example.demo.auth.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rn) throws SQLException {
        User u = new User();
        u.setActive(rs.getInt("active"));
        u.setPassword(rs.getString("password"));
        u.setRecovery_code(rs.getString("recovery_code"));
        u.setType(rs.getString("type"));
        u.setUsername(rs.getString("username"));
        return u;
    }
}