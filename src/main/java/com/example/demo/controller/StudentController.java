package com.example.demo.controller;

import com.example.demo.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "John",
                "Doe"
        );
        return student;
    }


    @GetMapping("/students")
    public List<Student> getStudents(){
         List<Student> student = new ArrayList<>();
         student.add(new Student(1,"Ramesh","Fadatare"));
         student.add(new Student(2,"umest","fadatare"));
         return student;
    }

    @GetMapping("/students/{id}/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("firstName") String firstName,
                                       @PathVariable("lastName") String lastName){
        return new Student(studentId,"Ramesh","Fadatare");
    }



//    http://localhost:8091/students/query?id=1
    @GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int id){
        return new Student(id,"Ramesh","Fadatare");
    }
}
