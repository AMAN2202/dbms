package com.example.rowmapper;

import com.example.demo.entity.Supplier;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SupplierRowMapper implements RowMapper<Supplier> {
    public Supplier mapRow(ResultSet rs, int rn) throws SQLException {
        Supplier s = new Supplier();
        s.setPerson_id(rs.getInt("person_id"));
        s.setSupplier_id(rs.getInt("supplier_id"));
        return s;

    }
}