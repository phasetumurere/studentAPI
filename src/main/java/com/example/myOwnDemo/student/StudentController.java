package com.example.myOwnDemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("getStudents")
    public List<Student> getStudents(){
       return studentService.getStudents();
    }
    @PostMapping("addStudent")
    public void registerNewStudent(@RequestBody Student student){studentService.insertStudent(student);
    }

}
