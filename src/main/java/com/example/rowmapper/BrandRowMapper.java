package com.example.rowmapper;

import com.example.demo.entity.Brand;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRowMapper implements RowMapper<Brand> {
    public Brand mapRow(ResultSet rs, int rn) throws SQLException {
        Brand b = new Brand();
        b.setBrand_id(rs.getInt("brand_id"));
        b.setBrand_name(rs.getString("brand_name"));
        b.setLogo(rs.getString("logo"));
        return b;
    }
}