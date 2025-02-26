package com.practice.studentInformationSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private Integer id;
    private String name;
    private String address;
    private Integer phone;
}
