package com.student.sms.backend.io;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest {

    @NotBlank(message = "Name shouldn't be blank")
    private String name;

    @NotNull(message = "Email shouldn't be null")
    @Email(message = "Enter valid email")
    private String email;

    @Min(value = 6,message = "Password must be altest 6 characters")
    private String password;
}
