package com.example.myOwnDemo.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
       return studentRepository.findAll();
    }

    public void insertStudent(Student student) {
       Optional<Student>studentOptional= studentRepository.findStudentByEmail(student.getEmail());
       Optional<Student>studentOptional1=studentRepository.findStudentByName(student.getName());
       if(studentOptional.isPresent()){
           throw new IllegalStateException("Email taken");
       }
        studentRepository.save(student);
        System.out.println(student.getName());

    }

}
