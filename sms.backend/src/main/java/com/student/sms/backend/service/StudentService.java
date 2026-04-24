package com.student.sms.backend.service;

import com.student.sms.backend.dto.StudentDto;
import com.student.sms.backend.dto.TeacherDto;
import com.student.sms.backend.entity.Student;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface StudentService {


    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(Long id,StudentDto updateStudent);

    void deleteStudent(Long id);



    Map<String,Object> searchAllStudent(String name,String department,int pageNo,int pageSize,String sortBy,String sortDir);



}
