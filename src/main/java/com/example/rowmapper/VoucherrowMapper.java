package com.example.rowmapper;

import com.example.demo.entity.Vouchers;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class VoucherrowMapper implements RowMapper<Vouchers> {
    public Vouchers mapRow(ResultSet rs, int rn) throws SQLException {
        Vouchers v = new Vouchers();
        v.setCredits(rs.getInt("credits"));
        v.setCustomerid(rs.getInt("customerid"));
        v.setVoucher_id(rs.getInt("voucher_id"));
        v.setActive(rs.getInt("active"));
        return v;

    }
}