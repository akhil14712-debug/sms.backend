package com.student.sms.backend.repository;

import com.student.sms.backend.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {



    @Query("Select s from Student s where Lower(s.sname) like lower(concat('%',:name,'%')) AND Lower(s.department) like lower(concat('%',:department,'%'))")
    Page<Student> searchStudent(@Param("name") String name, @Param("department") String department, Pageable pageable);



}
