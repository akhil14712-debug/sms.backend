package com.student.sms.backend.controller;

import com.student.sms.backend.dto.StudentDto;
import com.student.sms.backend.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    //Build Add Student Rest Api
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid StudentDto studentDto){
        StudentDto savedStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    //Build Get Student by id Rest Api

    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        StudentDto studentDto = studentService.getStudentById(id);
        return new ResponseEntity<>(studentDto,HttpStatus.OK);
    }

    //Build Get Student Rest Api
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getAllStudents();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }



    //Build Rest Api for Update
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,@RequestBody StudentDto updatedStudent){
        StudentDto studentDto = studentService.updateStudent(id,updatedStudent);

        return new ResponseEntity<>(studentDto,HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Deleted Succesfully");

    }

    @GetMapping("/count")
    public ResponseEntity<Long> getTotalCount(){
        long total = studentService.getTotalCount();
        return ResponseEntity.ok(total);
    }


    //Api for getting student details using name
    @GetMapping("/search")

    public ResponseEntity<List<StudentDto>> searchName(@RequestParam(value= "name",defaultValue = "") String name){

        if(name.trim().isEmpty()){
            return ResponseEntity.ok(studentService.getAllStudents());
        }
        List<StudentDto> result = studentService.searchByName(name);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


    @GetMapping("/sort/name")
    public ResponseEntity<List<StudentDto>> sortByName(){
        List<StudentDto> result = studentService.sortByName();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

 }
