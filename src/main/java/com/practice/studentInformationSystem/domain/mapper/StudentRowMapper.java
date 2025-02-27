package com.practice.studentInformationSystem.domain.mapper;

import com.practice.studentInformationSystem.domain.StudentResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<StudentResponse> {
    @Override
    public StudentResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(rs.getInt("id"));
        studentResponse.setName(rs.getString("name"));
        studentResponse.setAddress(rs.getString("address"));
        studentResponse.setPhone(rs.getInt("phone"));
        return studentResponse;
    }
}
