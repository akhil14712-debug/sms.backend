package com.student.sms.backend.dto;


import com.student.sms.backend.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class CourseDto {

    private Long courseId;
    private String courseName;
    private double fee;
    private String duration;
    private Long teacherId;


}
