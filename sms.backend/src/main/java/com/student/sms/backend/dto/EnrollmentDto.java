package com.student.sms.backend.dto;


//Server will return it


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class EnrollmentDto {
    private Long enrollmentId;
    private String studentName;
    private String courseName;
    private LocalDate enrollmentDate;
    private String status;
}
