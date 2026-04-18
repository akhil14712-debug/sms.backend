package com.student.sms.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentDto {



    private Long sid;

    @NotBlank(message="student name shouldn't be blank ")
    private String sname;

    @NotBlank(message="Department name shouldn't be blank")
    private String department;

    @Email(message="Email must be valid address")
    @NotBlank(message="Email shouldn't be blank")
    private String semail;

    @NotBlank(message="Invalid mobile entered")
    private String sphone;

}
