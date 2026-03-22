package com.student.sms.backend.service;

import com.student.sms.backend.dto.StudentDto;
import com.student.sms.backend.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    TeacherDto createTeacher(TeacherDto teacherDto);


    TeacherDto getTeacherById(Long teacherId);

    List<TeacherDto> getAllTeacher();

    TeacherDto updateTeacher(Long teacherId, TeacherDto updatedTeacher);

    void deleteTeacher(Long teacherId);

    long getCount();
}
