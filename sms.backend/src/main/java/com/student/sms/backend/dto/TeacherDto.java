package com.student.sms.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class TeacherDto {

    private long teacherId;
    private String tname;
    private String temail;
    private String tphone;
    private String qualification;
}
