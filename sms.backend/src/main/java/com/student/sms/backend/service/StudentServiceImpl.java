package com.student.sms.backend.service;

import com.student.sms.backend.dto.StudentDto;
import com.student.sms.backend.entity.Student;
import com.student.sms.backend.exception.ResourceNotFoundException;
import com.student.sms.backend.mapper.StudentMapper;
import com.student.sms.backend.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto){

        Student student = StudentMapper.mapToStudent(studentDto);
        Student createStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(createStudent);
    }

    @Override
    public StudentDto getStudentById(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student is not exists with given Id:"+id));

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDto = new ArrayList<>();

        for(Student student:students){
            StudentDto dto = StudentMapper.mapToStudentDto(student);
            studentDto.add(dto);
        }

        return studentDto;
    }
    @Override

    public StudentDto updateStudent(Long id,StudentDto updatedStudent){
        Student student = studentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student is not exist with given id"+id));
        student.setStudentId(updatedStudent.getStudentId());
        student.setSname(updatedStudent.getSname());
        student.setSemail(updatedStudent.getSemail());
        student.setSphone(updatedStudent.getSphone());

        Student updateStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updateStudent);
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student is not exist with given id"+id));

        studentRepository.deleteById(id);

    }

    @Override
    public long getTotalCount() {
        return studentRepository.count();
    }

}
