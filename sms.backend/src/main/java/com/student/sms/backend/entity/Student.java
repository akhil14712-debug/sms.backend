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
    private Long id;
    @Column(name="student_id")
    private String studentId;
    @Column(name="name")
    private String name;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    @Column(name="phone",length = 10,unique = true,nullable = false)
    private String phone;

}
