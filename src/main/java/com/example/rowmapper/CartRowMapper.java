package com.example.rowmapper;

import com.example.demo.entity.Cart;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CartRowMapper implements RowMapper<Cart> {
    public Cart mapRow(ResultSet rs, int rn) throws SQLException {
        Cart c = new Cart();
        c.setCustomer_id(rs.getInt("customer_id"));
        c.setItem_id(rs.getInt("item_id"));
        c.setQuantity(rs.getInt("quantity"));
        return c;
    }
}