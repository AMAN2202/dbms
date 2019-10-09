package com.example.rowmapper;

import com.example.demo.entity.Personal_info;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Personal_infoRowMapper implements RowMapper<Personal_info> {
    public Personal_info mapRow(ResultSet rs, int rn) throws SQLException {
        Personal_info p = new Personal_info();
        p.setAdharno(rs.getString("adharno"));
        p.setDob(rs.getDate("dob"));
        p.setEmail(rs.getString("email"));
        p.setFirstname(rs.getString("firstname"));
        p.setLastname(rs.getString("lastname"));
        p.setGender(rs.getString("gender"));
        p.setPhoneno(rs.getString("phoneno"));
        p.setZipcode(rs.getString("zipcode"));
        p.setAddress(rs.getString("address"));
        p.setPerson_id(rs.getInt("person_id"));
        return p;
    }
}