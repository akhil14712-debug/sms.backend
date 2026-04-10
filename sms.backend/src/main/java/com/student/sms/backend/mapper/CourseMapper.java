package com.student.sms.backend.mapper;

import com.student.sms.backend.dto.CourseDto;
import com.student.sms.backend.entity.Course;
import com.student.sms.backend.entity.Teacher;

public class CourseMapper {

    public static Course mapToCourse(CourseDto courseDto , Teacher teacher){
        Course course = new Course();
        course.setCourseId(courseDto.getCourseId());
        course.setCourseName(courseDto.getCourseName());
        course.setFee(courseDto.getFee());
        course.setDuration(courseDto.getDuration());
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
                course.getTeacher().getTeacherId()
        );
    }
}
