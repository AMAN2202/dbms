package com.example.rowmapper;

import com.example.demo.entity.Wages;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class WagesRowMapper implements RowMapper<Wages> {
    public Wages mapRow(ResultSet rs, int rn) throws SQLException {
        Wages v = new Wages();
        v.setAmount(rs.getInt("amount"));
        v.setDate(rs.getDate("date"));
        v.setEmployee_id(rs.getInt("employee_id"));
        v.setWage_id(rs.getInt("wage_id"));
        return v;

    }
}