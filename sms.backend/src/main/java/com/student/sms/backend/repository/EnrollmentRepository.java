package com.student.sms.backend.repository;

import com.student.sms.backend.dto.EnrollmentDto;
import com.student.sms.backend.entity.Enrollment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {

    @Query("Select r from Enrollment r where Lower(r.student.sname) like " +
            "Lower(Concat('%',:name,'%')) AND Lower(r.course.courseName) like Lower(Concat('%',:course,'%')) AND " +
            "Lower(r.status) like Lower(Concat('%',:status,'%'))")
    Page<Enrollment> searchEnrollment( String name ,  String course,  String status , Pageable pageable);
}

