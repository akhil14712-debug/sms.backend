package com.student.sms.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CourseDto {

    private Long courseId;
    private String courseName;
    private String description;
    private double fee;
    private String duration;
    private String teacherName;
}
