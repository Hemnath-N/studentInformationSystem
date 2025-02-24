package com.practice.studentInformationSystem.controller;

import com.practice.studentInformationSystem.domain.StudentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestCotroller {

    @GetMapping
    public ResponseEntity<StudentResponse> getStudentInformation () {
        return null;
    }

}
