package com.example.rowmapper;

import com.example.demo.entity.Income_tax;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class IncomeTaxRowMapper implements RowMapper<Income_tax> {
    public Income_tax mapRow(ResultSet rs, int rn) throws SQLException {
        Income_tax i = new Income_tax();
        i.setAmount(rs.getInt("amount"));
        i.setDate(rs.getDate("date"));
        i.setIncome_tax_id(rs.getInt("income_tax_id"));
        i.setPenality(rs.getInt("penality"));
        return i;
    }
}