package com.student.sms.backend.mapper;

import com.student.sms.backend.dto.StudentDto;
import com.student.sms.backend.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getSid(),
                student.getStudentId(),
                student.getSname(),
                student.getSemail(),
                student.getSphone()
        );
    }

    public static Student mapToStudent(StudentDto studentDto){
        Student student = new Student(
                studentDto.getSid(),
                studentDto.getStudentId(),
                studentDto.getSname(),
                studentDto.getSemail(),
                studentDto.getSphone());
        return student;
    }
}
