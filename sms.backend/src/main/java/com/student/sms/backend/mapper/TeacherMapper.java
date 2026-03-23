package com.student.sms.backend.mapper;

import com.student.sms.backend.dto.TeacherDto;
import com.student.sms.backend.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public static TeacherDto mapToTeacherDto(Teacher teacher){
        return new TeacherDto(
                teacher.getTeacherId(),
                teacher.getTname(),
                teacher.getTemail(),
                teacher.getTphone(),
                teacher.getQualification()
        );
    }

    public static Teacher mapToTeacher(TeacherDto teacherDto){
        Teacher teacher = new Teacher(
                teacherDto.getTeacherId(),
                teacherDto.getTname(),
                teacherDto.getTemail(),
                teacherDto.getTphone(),
                teacherDto.getQualification());

        return teacher;

    }


}
