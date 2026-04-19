package com.student.sms.backend.service;


import com.student.sms.backend.dto.DashboardDto;
import com.student.sms.backend.repository.CourseRepository;
import com.student.sms.backend.repository.EnrollmentRepository;
import com.student.sms.backend.repository.StudentRepository;
import com.student.sms.backend.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Setter
@Getter
@Service
public class DashboardService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private EnrollmentRepository enrollmentRepository;
    private TeacherRepository teacherRepository;

    public DashboardDto getDashboard(){
        return new DashboardDto(
                studentRepository.count(),
                courseRepository.count(),
                enrollmentRepository.count(),
                teacherRepository.count()
        );
    }


}
