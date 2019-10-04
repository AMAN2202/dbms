package com.example.rowmapper;

import com.example.demo.entity.Expenses;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ExpensesRowMapper implements RowMapper<Expenses> {
    public Expenses mapRow(ResultSet rs, int rn) throws SQLException {
        Expenses e = new Expenses();
        e.setAmount(rs.getInt("amount"));
        e.setDate(rs.getDate("date"));
        e.setDescription(rs.getString("description"));
        e.setExpenses_id(rs.getInt("expenses_id"));
        e.setType(rs.getString("type"));
        return e;

    }
}