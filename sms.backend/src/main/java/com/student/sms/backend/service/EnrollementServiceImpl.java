package com.student.sms.backend.service;

import com.student.sms.backend.dto.EnrollmentDto;
import com.student.sms.backend.dto.EnrollmentRequestDto;
import com.student.sms.backend.entity.Course;
import com.student.sms.backend.entity.Enrollment;
import com.student.sms.backend.entity.Student;

import com.student.sms.backend.exception.ResourceNotFoundException;
import com.student.sms.backend.mapper.EnrollmentMapper;
import com.student.sms.backend.repository.CourseRepository;
import com.student.sms.backend.repository.EnrollmentRepository;
import com.student.sms.backend.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class EnrollementServiceImpl implements EnrollementService{

    private EnrollmentRepository enrollmentRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;


    public EnrollementServiceImpl(EnrollmentRepository enrollmentRepository,StudentRepository studentRepository , CourseRepository courseRepository){
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public EnrollmentDto createEnroll(EnrollmentRequestDto enrollmentRequestDto) {


        Student student = studentRepository.findById(enrollmentRequestDto.getStudentId())
                .orElseThrow(()-> new ResourceNotFoundException("Student not found"+enrollmentRequestDto.getStudentId()));

        Course course = courseRepository.findById(enrollmentRequestDto.getCourseId())
                .orElseThrow(()-> new ResourceNotFoundException("Cource not found"+enrollmentRequestDto.getCourseId()));

        Enrollment e = new Enrollment();
        e.setStudent(student);
        e.setCourse(course);
        e.setEnrollmentDate(enrollmentRequestDto.getEnrollmentDate());
        e.setStatus(enrollmentRequestDto.getStatus());

        return EnrollmentMapper.mapToDto(enrollmentRepository.save(e));


    }
}
