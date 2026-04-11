package com.student.sms.backend.mapper;

import com.student.sms.backend.dto.CourseDto;
import com.student.sms.backend.dto.CourseRequestDto;
import com.student.sms.backend.entity.Course;
import com.student.sms.backend.entity.Teacher;

public class CourseMapper {

    public static Course mapToCourse(CourseRequestDto courseRequestDto, Teacher teacher){
        Course course = new Course();
        course.setCourseId(courseRequestDto.getCourseId());
        course.setCourseName(courseRequestDto.getCourseName());
        course.setFee(courseRequestDto.getFee());
        course.setDuration(courseRequestDto.getDuration());
        course.setTeacher(teacher);
        course.setEnrollments(null);

        return course;
    }

    public static CourseDto mapToCourseDto(Course course){
        return new CourseDto(
                course.getCourseId(),
                course.getCourseName(),
                course.getFee(),
                course.getDuration(),
                course.getTeacher().getTname()
        );
    }
}
