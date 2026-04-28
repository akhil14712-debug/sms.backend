package com.student.sms.backend.controller;


import com.student.sms.backend.dto.EnrollmentDto;
import com.student.sms.backend.dto.EnrollmentRequestDto;
import com.student.sms.backend.service.EnrollementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/enrollment")


public class EnrollmentController {

    private final EnrollementService enrollementService;




    @PostMapping
    public ResponseEntity<EnrollmentDto> createEnroll(@RequestBody @Valid  EnrollmentRequestDto enrollmentRequestDto){
        EnrollmentDto created = enrollementService.createEnroll(enrollmentRequestDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
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

    @GetMapping

    public ResponseEntity<Map<String,Object>> searchEnrollment(@RequestParam(defaultValue = "") String name,
                                                               @RequestParam(defaultValue = "") String course,
                                                               @RequestParam(defaultValue = "") String status,
                                                               @RequestParam(defaultValue = "0") int pageNo,
                                                               @RequestParam(defaultValue = "10") int pageSize ,
                                                               @RequestParam(defaultValue = "name") String sortBy,
                                                               @RequestParam(defaultValue = "asc") String sortDir){

        Map<String,Object> result = enrollementService.searchEnrollemts(name,course,status,pageNo,pageSize,sortBy,sortDir);

        return ResponseEntity.ok(result);

    }

    @GetMapping("/all")
    public ResponseEntity<List<EnrollmentDto>> getAllEnrollment(){
        List<EnrollmentDto> result = enrollementService.getAllEnrollemnts();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }




}
