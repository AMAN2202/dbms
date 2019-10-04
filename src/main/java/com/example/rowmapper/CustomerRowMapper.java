package com.example.rowmapper;

import com.example.demo.entity.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerRowMapper implements RowMapper<Customer> {
    public Customer mapRow(ResultSet rs, int rn) throws SQLException {
        Customer c = new Customer();
        c.setUsername(rs.getString("username"));
        c.setPerson_id(rs.getInt("person_id"));
        c.setCustomer_id(rs.getInt("customer_id"));
        return c;
    }
}