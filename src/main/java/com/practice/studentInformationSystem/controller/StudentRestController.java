package com.practice.studentInformationSystem.controller;

import com.practice.studentInformationSystem.domain.StudentRequest;
import com.practice.studentInformationSystem.domain.StudentResponse;
import com.practice.studentInformationSystem.service.StudentInformationProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentInformationProcessorService studentInformationProcessorService;

    @GetMapping
    public ResponseEntity<StudentResponse> getStudentInformation(@PathVariable Integer id) {
        return ResponseEntity.ok(studentInformationProcessorService.getStudentById(id));
    }

    @PutMapping
    public ResponseEntity<String> updateStudentInformation(@RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok(studentInformationProcessorService.updateStudentById(studentRequest));
    }

    @PostMapping
    public ResponseEntity<String> addStudentInformation(@RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok(studentInformationProcessorService.addStudent(studentRequest));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudentInformation(@RequestParam Integer id) {
        return ResponseEntity.ok(studentInformationProcessorService.deleteStudentById(id));
    }
}
