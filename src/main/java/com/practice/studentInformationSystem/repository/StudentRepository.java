package com.practice.studentInformationSystem.repository;

import com.practice.studentInformationSystem.domain.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static String FETCH_STUDENT = "SELECT * FROM STUDENT WHERE ID = :id";

    public StudentResponse getStudentById(final Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        try{
            return namedParameterJdbcTemplate.queryForObject(FETCH_STUDENT, params, StudentResponse.class);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
