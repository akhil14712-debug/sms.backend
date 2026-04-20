package com.student.sms.backend.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor


public class EnrollmentRequestDto {

    @NotNull(message = "Student id should not be null")
    private Long studentId;

    @NotNull(message = "Course id should not be null")
    private Long courseId;

    @NotNull(message = "Date should not be blank")
    private LocalDate enrollmentDate;

    @NotBlank(message = "Status should not be blank")
    private String status;
}
