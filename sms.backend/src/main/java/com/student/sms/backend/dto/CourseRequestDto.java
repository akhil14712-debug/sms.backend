package com.student.sms.backend.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class CourseRequestDto {

    private Long courseId;
    @NotBlank(message = "Course Name shoudln't be blank")
    private String courseName;

    @NotBlank(message = "Course Description shoudln't be blank")
    private String description;

    @DecimalMin(value = "0.0" ,inclusive = false , message = "Fee must be greater than 0")
    private double fee;

    @NotBlank(message = "Duration shouldn't not be blank")
    private String duration;

    @NotNull(message = "Teacher name shouldn't be blank")
    private Long teacherId;


}
