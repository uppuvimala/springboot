package com.task.springboot.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private long id;

    @Column(name = "student_firstName")
    private String firstName;
    @Column(name = "student_lastName")
    private String lastName;

    @Column(name = "email")
    private String email;
//@Column(name = "courseid")
//    private int courseid;
   @ManyToOne
   @JoinColumn(name = "courseid")
   //@JoinColumn(name = "courseid",insertable = false,updatable = false)
    private Course course;
}
