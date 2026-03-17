package com.student.sms.backend.mapper;

import com.student.sms.backend.dto.StudentDto;
import com.student.sms.backend.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getStudentId(),
                student.getName(),
                student.getEmail(),
                student.getPhone()
        );
    }

    public static Student mapToStudent(StudentDto studentDto){
        return new Student(
                studentDto.getId(),
                studentDto.getStudentId(),
                studentDto.getName(),
                studentDto.getEmail(),
                studentDto.getPhone()
        );
    }
}
