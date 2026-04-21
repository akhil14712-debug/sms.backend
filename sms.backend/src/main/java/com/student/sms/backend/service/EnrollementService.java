package com.student.sms.backend.service;

import com.student.sms.backend.dto.EnrollmentDto;
import com.student.sms.backend.dto.EnrollmentRequestDto;
import com.student.sms.backend.entity.Enrollment;

import java.util.List;

public interface EnrollementService {
    EnrollmentDto createEnroll(EnrollmentRequestDto enrollmentRequestDto);

    List<EnrollmentDto> getALLEnrollment();

    EnrollmentDto getById(Long id);



    Long getCount();

    EnrollmentDto updateEnrollment(Long id ,EnrollmentRequestDto enrollmentRequestDto);

    void deleteEnroll(Long id);

    List<EnrollmentDto> sortEnrollment(String sortBy, String direction);

    List<EnrollmentDto> searchEnrollment(String name,String course,String status);
}
