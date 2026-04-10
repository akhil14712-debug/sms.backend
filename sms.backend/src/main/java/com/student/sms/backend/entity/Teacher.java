package com.student.sms.backend.entity;


import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teacherId;

    @Column(name="tname",nullable = false)
    private String tname;

    @Column(name="temail" ,nullable = false , unique = true)
    private String temail;

    @Column(name="tphone",nullable = false,length = 10,unique = true)
    private String tphone;

    @Column(name="tqualification")
    private String qualification;


}
