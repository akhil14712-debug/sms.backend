package com.student.sms.backend.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Teacher name shouldn't be blank")
    private String tname;

    @NotBlank(message = "Teacher email shouldn't be blank")
    @Email(message = "Invalid email address")
    private String temail;

    @NotBlank(message = "Teacher phone shouldn't be blank")
    private String tphone;

    @NotBlank(message = "Teacher qualification shouldn't be blank")
    private String qualification;
}
