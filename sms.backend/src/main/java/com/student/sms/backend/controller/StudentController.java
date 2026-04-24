package com.student.sms.backend.controller;

import com.student.sms.backend.dto.StudentDto;
import com.student.sms.backend.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


    @GetMapping("search")
    public ResponseEntity<Map<String , Object>> getStudents(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String department,
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir

    ){
        Map<String,Object> result = studentService.searchAllStudent(name,department,pageNo,pageSize,sortBy,sortDir);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

  }












