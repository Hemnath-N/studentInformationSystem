package com.practice.studentInformationSystem.service;

import com.practice.studentInformationSystem.domain.StudentRequest;
import com.practice.studentInformationSystem.domain.StudentResponse;
import com.practice.studentInformationSystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentInformationProcessorService {

    private final StudentRepository studentRepository;

    public StudentResponse getStudentById(final Integer id) {
        return studentRepository.getStudentById(id);
    }

    public String updateStudentById(final StudentRequest studentRequest) {
        if (studentRepository.updateStudent(studentRequest)) {
            return String.format("Student Information has been updated successfully for id: %s", studentRequest.getId());
        } else {
            return String.format("Student Information not updated for id: %s", studentRequest.getId());
        }
    }

    public String addStudent(final StudentRequest studentRequest) {
        if (studentRepository.insertStudent(studentRequest)) {
            return String.format("Student Information has been added successfully for id: %s", studentRequest.getId());
        } else {
            return String.format("Student Information not added for id: %s", studentRequest.getId());
        }
    }

    public String deleteStudentById(final Integer id) {
        if (studentRepository.deleteStudent(id)) {
            return String.format("Student Information has been deleted successfully for id: %s", id);
        } else {
            return String.format("Student Information not deleted for id: %s", id);
        }
    }
}
