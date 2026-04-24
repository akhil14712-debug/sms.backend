package com.student.sms.backend.service;

import com.student.sms.backend.dto.EnrollmentDto;
import com.student.sms.backend.dto.EnrollmentRequestDto;
import com.student.sms.backend.entity.Enrollment;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

public interface EnrollementService {
    EnrollmentDto createEnroll(EnrollmentRequestDto enrollmentRequestDto);

   List<EnrollmentDto> getAllEnrollemnts();

    EnrollmentDto getById(Long id);



    Long getCount();

    EnrollmentDto updateEnrollment(Long id ,EnrollmentRequestDto enrollmentRequestDto);

    void deleteEnroll(Long id);

     Map<String,Object> searchEnrollemts(String name, String course, String status, int pageNo , int pageSize , String sortBy ,String sortDir);
}
