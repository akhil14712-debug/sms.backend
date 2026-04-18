package com.student.sms.backend.dto;


import jakarta.validation.constraints.NotNull;
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
    private Long enrollmets;
    private Long teacher;
}
