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
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EnrollementServiceImpl implements EnrollementService {

    private EnrollmentRepository enrollmentRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;


    @Override
    public EnrollmentDto createEnroll(EnrollmentRequestDto enrollmentRequestDto) {


        Student student = studentRepository.findById(enrollmentRequestDto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found" + enrollmentRequestDto.getStudentId()));

        Course course = courseRepository.findById(enrollmentRequestDto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Cource not found" + enrollmentRequestDto.getCourseId()));

        Enrollment e = new Enrollment();
        e.setStudent(student);
        e.setCourse(course);
        e.setEnrollmentDate(enrollmentRequestDto.getEnrollmentDate());
        e.setStatus(enrollmentRequestDto.getStatus());
        Enrollment e1 = enrollmentRepository.save(e);

        return EnrollmentMapper.mapToDto(e1);


    }

    @Override
    public List<EnrollmentDto> getAllEnrollemnts() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();

        return enrollments.stream()
                .map(EnrollmentMapper::mapToDto)
                .collect(Collectors.toList());
    }



    @Override
    public EnrollmentDto getById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The given id is not found"));

        return EnrollmentMapper.mapToDto(enrollment);
    }


    @Override
    public Long getCount() {
        Long result = enrollmentRepository.count();

        return result;
    }

    @Override
    public EnrollmentDto updateEnrollment(Long id, EnrollmentRequestDto enrollmentRequestDto) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The given enrollment id is not found" + id));
        Student student = studentRepository.findById(enrollmentRequestDto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("The given student id is not found" + id));
        Course course = courseRepository.findById(enrollmentRequestDto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("The given course id is not found"));

        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(enrollmentRequestDto.getEnrollmentDate());
        enrollment.setStatus(enrollmentRequestDto.getStatus());

        Enrollment result = enrollmentRepository.save(enrollment);

        return EnrollmentMapper.mapToDto(result);

    }

    @Override
    public void deleteEnroll(Long id) {
        enrollmentRepository.deleteById(id);
    }

    @Override
    public Map<String, Object> searchEnrollemts(String name, String course, String status, int pageNo, int pageSize, String sortBy, String sortDir) {

        String sortField = "";
        
        if(sortBy != null && !sortBy.trim().isEmpty()){
            switch(sortBy.toLowerCase()){
                case "name":
                    sortField = "student.sname";
                    break;
                case "course":
                    sortField = "course.courseName";
                    break;
                case "status":
                    sortField = "status";
                    break;
                case "enrollmentDate" :
                    sortField = "enrollmentDate";
                    break;
                default:
                sortField = "id";
            }
        }
        Sort sort = sortDir.equalsIgnoreCase("desc") ?
                Sort.by(sortField).descending():
                Sort.by(sortField).ascending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);

        Page<Enrollment> searchPage = enrollmentRepository.searchEnrollment(name,course,status,pageable);

        List<EnrollmentDto> dtoList = searchPage.getContent()
                .stream().map(EnrollmentMapper::mapToDto)
                .collect(Collectors.toList());


        Map<String,Object> map1 = new HashMap();
        map1.put("currentPage",searchPage.getNumber());
        map1.put("totalPages",searchPage.getTotalPages());
        map1.put("isLast",searchPage.isLast());
        map1.put("totalItems",searchPage.getTotalElements());


        Map<String,Object> map = new HashMap<>();
        map.put("data",dtoList);
        map.put("pagination",map1);




        return map;
    }


}
