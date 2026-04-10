package com.student.sms.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter


@Entity
@Table(name="enrollement")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name="student_id" , nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="course_id" , nullable = false)
    private Course course;

    @Column(name="enrollmentDate" , nullable = false)
    private LocalDate enrollmentDate;

    @Column(name="status",nullable = false)
    private String status;


}
