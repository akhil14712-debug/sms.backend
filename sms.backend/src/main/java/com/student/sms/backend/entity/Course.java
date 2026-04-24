package com.student.sms.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


//@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name="courseName" , nullable = false)
    private String courseName;

    @Column(name="description", nullable = false)
    private String description;


    @Column(name="fee" ,nullable = false)
    private double fee;

    @Column(name="duration" ,nullable = false)
    private String duration;

    @ManyToOne
    @JoinColumn(name="teacher_id",nullable = false)
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

}
