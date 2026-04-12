package com.student.sms.backend.mapper;

import com.student.sms.backend.dto.StudentDto;
import com.student.sms.backend.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getSid(),
                student.getSname(),
                student.getDepartment(),
                student.getSemail(),
                student.getSphone()
        );
    }

    public static Student mapToStudent(StudentDto studentDto){
        Student student = new Student(
                studentDto.getSid(),
                studentDto.getSname(),
                studentDto.getDepartment(),
                studentDto.getSemail(),
                studentDto.getSphone(),
                null
        );
        return student;
    }
}
