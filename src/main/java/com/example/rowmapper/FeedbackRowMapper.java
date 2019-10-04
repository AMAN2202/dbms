package com.example.rowmapper;

import com.example.demo.entity.Feedback;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class FeedbackRowMapper implements RowMapper<Feedback> {
    public Feedback mapRow(ResultSet rs, int rn) throws SQLException {
        Feedback f = new Feedback();
        f.setCustomer_id(rs.getInt("customer_id"));
        f.setDate(rs.getDate("date"));
        f.setRating(rs.getInt("rating"));
        f.setDescription(rs.getString("description"));
        f.setFeedback_id(rs.getInt("feedback_id"));
        return f;
    }
}