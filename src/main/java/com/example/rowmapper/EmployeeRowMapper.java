package com.example.rowmapper;

import com.example.demo.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeRowMapper implements RowMapper<Employee> {
    public Employee mapRow(ResultSet rs, int rn) throws SQLException {
        Employee e = new Employee();
        e.setPerson_id(rs.getInt("person_id"));
        e.setUsername(rs.getString("username"));
        e.setSalary(rs.getInt("salary"));
        e.setBalance(rs.getInt("balance"));
        e.setEmployee_id(rs.getInt("employee_id"));
        return e;
    }
}
