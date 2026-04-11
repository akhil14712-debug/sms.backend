package com.student.sms.backend.controller;


import com.student.sms.backend.dto.EnrollmentDto;
import com.student.sms.backend.dto.EnrollmentRequestDto;
import com.student.sms.backend.service.EnrollementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDto> getById(@PathVariable Long id){
        EnrollmentDto result = enrollementService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCount(){
        Long result = enrollementService.getCount();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EnrollmentDto> updateEnrollment(@PathVariable Long id ,@RequestBody EnrollmentRequestDto enrollmentRequestDto){
        EnrollmentDto result = enrollementService.updateEnrollment(id ,enrollmentRequestDto);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEnroll(@PathVariable Long id){

        enrollementService.deleteEnroll(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }


}
