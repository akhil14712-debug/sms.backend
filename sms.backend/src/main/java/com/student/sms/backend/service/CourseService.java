package com.student.sms.backend.service;

import com.student.sms.backend.dto.CourseDto;

import java.util.List;

public interface CourseService {

    CourseDto createCourse(CourseDto courseDto);

    CourseDto getCourseById(Long courseId);



    List<CourseDto> getAllCourse();

    CourseDto updateCourse(Long courseId, CourseDto updatedCourse);

    void deleteCourse(Long id);

    long getCourseCount();
}
