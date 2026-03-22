package com.student.sms.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name="student_id")
    private String studentId;
    @Column(name="sname" ,nullable = false)
    private String sname;
    @Column(name="semail",nullable = false,unique = true)
    private String semail;
    @Column(name="sphone",length = 10,unique = true,nullable = false)
    private String sphone;

}
