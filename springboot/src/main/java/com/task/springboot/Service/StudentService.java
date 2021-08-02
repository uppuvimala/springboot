package com.task.springboot.Service;

import com.task.springboot.Entity.Student;
import com.task.springboot.Exception.StudentNotFoundException;
import com.task.springboot.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //get all studentss
    public List<Student> getAllStudents(){
      return (List<Student>) studentRepository.findAll();

    }
    //create Student
    public Student createStudent(Student student)
    {
        return studentRepository.save(student);
    }


    //get StudentById
    public Optional<Student> getStudentbyId(Long id) throws StudentNotFoundException {
        Optional<Student> student=studentRepository.findById(id);
        if (!student.isPresent()){
            throw new StudentNotFoundException("Student not found");
        }
        return student;
    }
    //update StudentByd

    public Student updateStudentById( Long id, Student student){
        student.setId(id);
        return studentRepository.save(student);
    }
    //delete StudentById
    public void deleteById(Long id){
        if(studentRepository.findById(id).isPresent()){
            studentRepository.deleteById(id);
        }
    }
}
