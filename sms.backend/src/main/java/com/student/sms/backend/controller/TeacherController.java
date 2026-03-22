package com.student.sms.backend.controller;


import com.student.sms.backend.dto.StudentDto;
import com.student.sms.backend.dto.TeacherDto;
import com.student.sms.backend.service.StudentService;
import com.student.sms.backend.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherController {

    private final StudentService studentService;
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto){
        TeacherDto savedTeacher = teacherService.createTeacher(teacherDto);

        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    @GetMapping("{tid}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long tid){
        TeacherDto teacherDto = teacherService.getTeacherById(tid);
        return new ResponseEntity<>(teacherDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeacher(){
        List<TeacherDto> result = teacherService.getAllTeacher();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("{teacherId}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable Long teacherId, @RequestBody TeacherDto updatedTeacher){
        TeacherDto updated = teacherService.updateTeacher(teacherId,updatedTeacher);

        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("{teacherId}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long teacherId){
        teacherService.deleteTeacher(teacherId);
        return new ResponseEntity<>("Deleted succesfully",HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCount(){
        long count = teacherService.getCount();
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

}
