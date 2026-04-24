package com.student.sms.backend.mapper;

import com.student.sms.backend.dto.EnrollmentDto;
import com.student.sms.backend.entity.Course;
import com.student.sms.backend.entity.Enrollment;
import com.student.sms.backend.entity.Student;

public class EnrollmentMapper {

    public static EnrollmentDto mapToDto(Enrollment enrollment){
        EnrollmentDto dto = new EnrollmentDto();
        dto.setEnrollmentId(enrollment.getEnrollmentId());
        dto.setStudentName(enrollment.getStudent().getSname());
        dto.setCourseName(enrollment.getCourse().getCourseName());
        dto.setEnrollmentDate(enrollment.getEnrollmentDate());
        dto.setStatus(enrollment.getStatus());
        return dto;
    }

    public static Enrollment mapToEnrollment(EnrollmentDto dto , Student student , Course course){
        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentId(dto.getEnrollmentId());
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(enrollment.getEnrollmentDate());
        enrollment.setStatus(enrollment.getStatus());
        return enrollment;
    }
}
