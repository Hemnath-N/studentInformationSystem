package com.practice.studentInformationSystem.controller;

import com.practice.studentInformationSystem.domain.StudentRequest;
import com.practice.studentInformationSystem.domain.StudentResponse;
import com.practice.studentInformationSystem.service.StudentInformationProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentInformationProcessorService studentInformationProcessorService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentInformation(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(studentInformationProcessorService.getStudentById(id));
    }

    @PutMapping
    public ResponseEntity<String> updateStudentInformation(@RequestBody StudentRequest studentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentInformationProcessorService.updateStudentById(studentRequest));
    }

    @PostMapping
    public ResponseEntity<String> addStudentInformation(@RequestBody StudentRequest studentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentInformationProcessorService.addStudent(studentRequest));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudentInformation(@RequestParam Integer id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(studentInformationProcessorService.deleteStudentById(id));
    }
}
