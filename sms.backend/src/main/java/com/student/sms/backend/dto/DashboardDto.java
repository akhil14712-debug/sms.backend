package com.student.sms.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public class DashboardDto {

    private Long students;
    private Long course;
    private Long enrollemts;
    private Long teacher;
}
