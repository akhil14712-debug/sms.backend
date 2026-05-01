package com.student.sms.backend.controller;


import com.student.sms.backend.io.ProfileRequest;
import com.student.sms.backend.io.ProfileResponse;
import com.student.sms.backend.service.ProfileServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController

@AllArgsConstructor
public class ProfileController {

    private ProfileServiceImpl profileService;

    @PostMapping("/register")
    public ResponseEntity<ProfileResponse> register(@Valid @RequestBody ProfileRequest profileRequest){
        ProfileResponse response = profileService.createProfile(profileRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
