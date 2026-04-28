package com.student.sms.backend.service;

import com.student.sms.backend.dto.TeacherDto;
import com.student.sms.backend.entity.Teacher;
import com.student.sms.backend.exception.ResourceNotFoundException;
import com.student.sms.backend.mapper.TeacherMapper;
import com.student.sms.backend.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private TeacherRepository teacherRepository;

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher = TeacherMapper.mapToTeacher(teacherDto);
        Teacher createTeacher  = teacherRepository.save(teacher);


        return TeacherMapper.mapToTeacherDto(createTeacher);
    }

    @Override
    public TeacherDto getTeacherById(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(()-> new ResourceNotFoundException("The id is not found"+teacherId));

        return TeacherMapper.mapToTeacherDto(teacher);
    }

    @Override
    public List<TeacherDto> getAllTeacher() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherDto> result = new ArrayList<>();

        return teachers.stream()
                .map(TeacherMapper::mapToTeacherDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDto updateTeacher(Long teacherId, TeacherDto updatedTeacher) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(()-> new ResourceNotFoundException("Your given id is not found"+teacherId));

        teacher.setTname(updatedTeacher.getTname());
        teacher.setTemail(updatedTeacher.getTemail());
        teacher.setTphone(updatedTeacher.getTphone());
        teacher.setQualification(updatedTeacher.getQualification());

        Teacher result = teacherRepository.save(teacher);

        return TeacherMapper.mapToTeacherDto(result);
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("You'r given Id is not found"+teacherId));
        teacherRepository.deleteById(teacherId);
    }

    @Override
    public long getCount() {
        long count = teacherRepository.count();
        return count;
    }

    @Override
    public List<TeacherDto> searchTeacher(String name) {
        List<Teacher> lists = teacherRepository.getTeacherByName(name);

        return lists.stream()
                .map(TeacherMapper::mapToTeacherDto)
                .collect(Collectors.toList());
    }


}
