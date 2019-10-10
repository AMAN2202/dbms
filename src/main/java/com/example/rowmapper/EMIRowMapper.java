package com.example.rowmapper;

import com.example.demo.entity.Emi;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EMIRowMapper implements RowMapper<Emi> {
    public Emi mapRow(ResultSet rs, int rn) throws SQLException {
        Emi e = new Emi();
        e.setCustomer_id(rs.getInt("customer_id"));
        e.setEmi_id(rs.getInt("emi_id"));
        e.setIntrest(rs.getInt("intrest"));
        e.setItem_id(rs.getInt("item_id"));
        e.setPaid_fraction(rs.getInt("paid_fraction"));
        e.setTot_fraction(rs.getInt("tot_fraction"));
        e.setPending(rs.getInt("pending"));
        e.setEmi_id(rs.getInt("emi_id"));
        e.setPrincipal(rs.getInt("principal"));
        e.setDate(rs.getDate("date"));
        return e;

    }
}
