package com.student.sms.backend.controller;


import com.student.sms.backend.dto.CourseDto;
import com.student.sms.backend.dto.CourseRequestDto;
import com.student.sms.backend.service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody @Valid CourseRequestDto courseRequestDto){
        CourseDto savedCourse = courseService.createCourse(courseRequestDto);
        return new ResponseEntity<>(savedCourse,HttpStatus.CREATED);
    }

    @GetMapping("{courseId}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long courseId){
        CourseDto courseDto = courseService.getCourseById(courseId);

        return new ResponseEntity<>(courseDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourse(){
        List<CourseDto> getCourse = courseService.getAllCourse();

        return new ResponseEntity<>(getCourse , HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Long id , @RequestBody CourseRequestDto updatedCourse){
        CourseDto courseDto = courseService.updateCourse(id,updatedCourse);

        return new ResponseEntity<>(courseDto,HttpStatus.OK);
    }


    @DeleteMapping("{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok("Deleted succesfully");
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCourseCount(){
            long total = courseService.getCourseCount();
        return ResponseEntity.ok(total);
    }




}
