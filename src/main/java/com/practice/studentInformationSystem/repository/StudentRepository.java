package com.practice.studentInformationSystem.repository;

import com.practice.studentInformationSystem.domain.StudentRequest;
import com.practice.studentInformationSystem.domain.StudentResponse;
import com.practice.studentInformationSystem.domain.mapper.StudentRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudentRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static String FETCH_STUDENT = "SELECT * FROM STUDENT WHERE ID = :id";
    public static String UPDATE_STUDENT = "UPDATE STUDENT SET NAME = :name WHERE ID = :id";
    public static String INSERT_STUDENT = "INSERT INTO STUDENT (ID, NAME, ADDRESS, PHONE) "
            + "VALUES (:id, :name, :address, :phone)";
    public static String DELETE_STUDENT = "DELETE FROM STUDENT WHERE ID = :id";

    public StudentResponse getStudentById(final Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        try {
            return namedParameterJdbcTemplate.queryForObject(FETCH_STUDENT, params, new StudentRowMapper());
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean updateStudent(final StudentRequest studentRequest) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", studentRequest.getName());
        params.addValue("id", studentRequest.getId());
        try {
            return (namedParameterJdbcTemplate.update(UPDATE_STUDENT, params) > 0);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean insertStudent(final StudentRequest studentRequest) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", studentRequest.getName());
        params.addValue("id", studentRequest.getId());
        params.addValue("address", studentRequest.getAddress());
        params.addValue("phone", studentRequest.getPhone());
        try {
            return (namedParameterJdbcTemplate.update(INSERT_STUDENT, params) > 0);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean deleteStudent(final Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        try {
            return (namedParameterJdbcTemplate.update(DELETE_STUDENT, params) > 0);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
