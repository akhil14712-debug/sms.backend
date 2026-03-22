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

    private Long sid;
    private String studentId;
    private String sname;
    private String semail;
    private String sphone;

}
