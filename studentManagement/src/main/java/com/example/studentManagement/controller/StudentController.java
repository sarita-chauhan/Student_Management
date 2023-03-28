package com.example.studentManagement.controller;

import com.example.studentManagement.model.Student;
import com.example.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/all")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @GetMapping("/getByRoll/{rollNumber}")
    public Optional<Student> getStudentByRollNumber(@PathVariable("rollNumber") Integer rollNumber){
        return studentService.getStudentByRollNumber(rollNumber);
    }
    @DeleteMapping("/removeByRoll/{rollNumber}")
    public String removeStudent(@PathVariable("rollNumber") Integer rollNumber){
        return studentService.removeStudentById(rollNumber);
    }
    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) throws FileNotFoundException {
        return studentService.updateStudentRecords(student);
    }
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
}
