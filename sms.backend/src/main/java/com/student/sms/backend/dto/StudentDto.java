package com.student.sms.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentDto {

    private Long id;
    private String studentId;
    private String name;
    private String email;
    private String phone;

}
