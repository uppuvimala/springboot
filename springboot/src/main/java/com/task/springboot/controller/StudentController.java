package com.task.springboot.controller;

import com.task.springboot.Entity.Student;
import com.task.springboot.Exception.StudentNotFoundException;
import com.task.springboot.Repository.StudentRepository;
//import com.task.springboot.Service.StudentService;
import com.task.springboot.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

@Autowired
StudentService studentService;
    //StudentRepository studentRepository;

    //get student by studentid
    @GetMapping
public List<Student> getAllStudents(){
    return studentService.getAllStudents();
}
    //create student
    @PostMapping("/createStudent")
public Student saveStudent(@RequestBody Student student){
        return studentService.createStudent(student);
}

//get StudentById
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Long id){
       try{ return studentService.getStudentbyId(id);
    }catch (StudentNotFoundException ex){
       throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
       }
    }
    //update studentById details
    @PutMapping("/{id}")
public Student UpdateStudentById(@PathVariable("id") Long id,@RequestBody Student student){
        return studentService.updateStudentById(id, student);
}
    //delete studentById
    @DeleteMapping("/{id}")
    public void deleteStudenById(@PathVariable("id") Long id){
        studentService.deleteById(id);
    }
}
