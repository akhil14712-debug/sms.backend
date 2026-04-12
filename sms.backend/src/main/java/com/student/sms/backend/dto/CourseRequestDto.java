package com.student.sms.backend.dto;


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
    private String courseName;
    private String description;
    private double fee;
    private String duration;
    private Long teacherId;


}
