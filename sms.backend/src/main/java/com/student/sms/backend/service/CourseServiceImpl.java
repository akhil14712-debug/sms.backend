package com.student.sms.backend.service;

import com.student.sms.backend.dto.CourseDto;
import com.student.sms.backend.dto.CourseRequestDto;
import com.student.sms.backend.entity.Course;
import com.student.sms.backend.entity.Teacher;
import com.student.sms.backend.exception.ResourceNotFoundException;
import com.student.sms.backend.mapper.CourseMapper;
import com.student.sms.backend.repository.CourseRepository;
import com.student.sms.backend.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;
    private TeacherRepository teacherRepository;

    @Override

    public CourseDto createCourse(CourseRequestDto courseRequestDto){
        Teacher teacher = teacherRepository.findById(courseRequestDto.getTeacherId())
                .orElseThrow(() -> new ResourceNotFoundException("Teacher id is not found"));
        Course course = CourseMapper.mapToCourse(courseRequestDto,teacher);
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
            CourseDto dto = CourseMapper.mapToCourseDto(course);
            CourseDto.add(dto);
        }

        return CourseDto;
    }

    @Override

    public CourseDto updateCourse(Long id, CourseRequestDto updatedCourse) {
        Course course = courseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Give id is not found"+id));

        Teacher teacher = teacherRepository.findById(updatedCourse.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        course.setCourseName(updatedCourse.getCourseName());
        course.setDescription(updatedCourse.getDescription());
        course.setFee(updatedCourse.getFee());
        course.setDuration(updatedCourse.getDuration());
        course.setTeacher(teacher);

        Course result = courseRepository.save(course);

        CourseDto courseDto = CourseMapper.mapToCourseDto(result);
        return courseDto;
    }

    @Override
    public void deleteCourse(Long id) {
        Course course  = courseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Your given id is not found"));

        courseRepository.delete(course);
    }

    @Override
    public long getCourseCount() {
        return courseRepository.count();
    }
}
