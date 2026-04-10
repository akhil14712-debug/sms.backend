package com.student.sms.backend.service;

import com.student.sms.backend.dto.EnrollmentDto;
import com.student.sms.backend.dto.EnrollmentRequestDto;
import com.student.sms.backend.entity.Enrollment;

public interface EnrollementService {
    EnrollmentDto createEnroll(EnrollmentRequestDto enrollmentRequestDto);
}
