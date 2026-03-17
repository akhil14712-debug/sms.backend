package com.student.sms.backend.mapper;

import com.student.sms.backend.dto.CourseDto;
import com.student.sms.backend.entity.Course;

public class CourseMapper {

    public static Course mapToCourse(CourseDto courseDto){
        return new Course(
           courseDto.getCourseId(),
           courseDto.getCourseName(),
           courseDto.getInstructor(),
           courseDto.getFee(),
           courseDto.getDuration()
        );
    }

    public static CourseDto mapToCourseDto(Course course){
        return new CourseDto(
                course.getCourseId(),
                course.getCourseName(),
                course.getInstructor(),
                course.getFee(),
                course.getDuration()
        );
    }
}
