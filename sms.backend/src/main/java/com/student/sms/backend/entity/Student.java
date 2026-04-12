package com.student.sms.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @Column(name="sname" ,nullable = false)
    private String sname;


    @Column(name="department")
    private String department;

    @Column(name="semail",nullable = false,unique = true)
    private String semail;

    @Column(name="sphone",length = 10,unique = true,nullable = false)
    private String sphone;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

}
