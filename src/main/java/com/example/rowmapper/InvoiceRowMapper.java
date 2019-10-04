package com.example.rowmapper;

import com.example.demo.entity.Invoice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class InvoiceRowMapper implements RowMapper<Invoice> {
    public Invoice mapRow(ResultSet rs, int rn) throws SQLException {
        Invoice i = new Invoice();
        i.setAmount(rs.getInt("amount"));
        i.setDate(rs.getDate("date"));
        i.setInvoice_id(rs.getInt("invoice_id"));
        i.setSupplierid(rs.getInt("supplierid"));
        return i;
    }
}