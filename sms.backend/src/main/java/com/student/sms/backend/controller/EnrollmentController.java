package com.student.sms.backend.controller;


import com.student.sms.backend.dto.EnrollmentDto;
import com.student.sms.backend.dto.EnrollmentRequestDto;
import com.student.sms.backend.service.EnrollementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/enrollment")


public class EnrollmentController {

    private final EnrollementService enrollementService;

    @PostMapping
    public ResponseEntity<EnrollmentDto> createEnroll(@RequestBody EnrollmentRequestDto enrollmentRequestDto){
        EnrollmentDto created = enrollementService.createEnroll(enrollmentRequestDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDto>> getAllEnrollemnt(){
        List<EnrollmentDto> list = enrollementService.getALLEnrollment();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
