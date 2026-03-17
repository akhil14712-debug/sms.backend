package com.student.sms.backend.service;

import com.student.sms.backend.dto.CourseDto;
import com.student.sms.backend.entity.Course;
import com.student.sms.backend.exception.ResourceNotFoundException;
import com.student.sms.backend.mapper.CourseMapper;
import com.student.sms.backend.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    @Override

    public CourseDto createCourse(CourseDto courseDto){
        Course course = CourseMapper.mapToCourse(courseDto);
        Course createCourse = courseRepository.save(course);
        return CourseMapper.mapToCourseDto(createCourse);
    }

    @Override
    public CourseDto getCourseById(Long courseId){
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course is not exist with given id"+courseId));

        return CourseMapper.mapToCourseDto(course);
    }



    @Override
    public List<CourseDto> getAllCourse() {

        List<Course> courses = courseRepository.findAll();
        List<CourseDto> CourseDto = new ArrayList();

        for(Course course:courses){
            CourseDto  dto = CourseMapper.mapToCourseDto(course);
            CourseDto.add(dto);
        }

        return CourseDto;
    }

    @Override
    public CourseDto updateCourse(Long courseId, CourseDto updatedCourse) {
        Course course = courseRepository.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Give id is not found"+courseId));

        course.setCourseId(updatedCourse.getCourseId());
        course.setCourseName(updatedCourse.getCourseName());
        course.setInstructor(updatedCourse.getInstructor());
        course.setFee(updatedCourse.getFee());
        course.setDuration(updatedCourse.getDuration());

        Course courseD = courseRepository.save(course);

        CourseDto courseDto = CourseMapper.mapToCourseDto(courseD);
        return courseDto;
    }

    @Override
    public void deleteCourse(Long id) {
        Course course  = courseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Your given id is not found"));

        courseRepository.delete(course);
    }
}
