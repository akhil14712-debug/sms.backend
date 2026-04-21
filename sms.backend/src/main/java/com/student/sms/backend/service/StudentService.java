package com.student.sms.backend.service;

import com.student.sms.backend.dto.StudentDto;
import com.student.sms.backend.dto.TeacherDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {


    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(Long id,StudentDto updateStudent);

    void deleteStudent(Long id);

    long getTotalCount();

    List<StudentDto> searchByName(String name);




    List<StudentDto> getByPages(Pageable pageable);
}
