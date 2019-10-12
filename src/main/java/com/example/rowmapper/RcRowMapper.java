package com.example.rowmapper;

import com.example.demo.entity.Reciept;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RcRowMapper implements RowMapper<Reciept> {
    public Reciept mapRow(ResultSet rs, int rn) throws SQLException {
        Reciept r = new Reciept();
        r.setDiscount(rs.getInt("discount"));
        r.setAmount(rs.getInt("amount"));
        r.setAmount_payed(rs.getInt("amount_payed"));
        r.setDate(rs.getDate("date"));
        r.setReceipt_id(rs.getInt("receipt_id"));
        return r;
    }
}
