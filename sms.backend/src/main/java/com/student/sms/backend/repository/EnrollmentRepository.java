package com.student.sms.backend.repository;

import com.student.sms.backend.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {

    @Query("Select r from Enrollment r Where LOWER(r.student.sname) like Lower(CONCAT('%',:name,'%')) AND LOWER(r.course.courseName) like Lower(CONCAT('%',:course,'%')) AND LOWER(r.status) like Lower(CONCAT('%',:status,'%'))")
    List<Enrollment> searchEnrollment(@Param("name") String name,
                                    @Param("course") String course,
                                    @Param("status") String status);
}
