package com.student.sms.backend.service;

import com.student.sms.backend.dto.CourseDto;
import com.student.sms.backend.dto.CourseRequestDto;

import java.util.List;

public interface CourseService {

    CourseDto createCourse(CourseRequestDto courseRequestDto);

    CourseDto getCourseById(Long courseId);



    List<CourseDto> getAllCourse();

    CourseDto updateCourse(Long id, CourseRequestDto updatedCourse);

    void deleteCourse(Long id);

    long getCourseCount();
}
