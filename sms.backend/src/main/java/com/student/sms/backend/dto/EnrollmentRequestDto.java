package com.student.sms.backend.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class EnrollmentRequestDto {

    private Long studentId;
    private Long courseId;
    private LocalDate enrollmentDate;
    private String status;
}
