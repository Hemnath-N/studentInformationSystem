package com.practice.studentInformationSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Integer id;
    private String name;
    private String address;
    private Integer phone;
}
