package com.student.sms.backend.repository;

import com.student.sms.backend.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    @Query("SELECT t FROM Teacher t where lower(t.tname) Like LOWER(CONCAT('%',:name,'%')) ")
    public List<Teacher> getTeacherByName(@Param("name") String name);
}
