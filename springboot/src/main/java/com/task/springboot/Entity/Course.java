package com.task.springboot.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseid;
    private String coursecontent;


    //mutliple courses can be taken by student--untill unless course.getstudent student obj is notgng to b fetched byorder
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id")
    @JsonIgnore
    //when course is gng to send it expects student data to b send
    private List<Student> students;
}
