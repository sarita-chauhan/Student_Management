package com.example.studentManagement.service;

import com.example.studentManagement.model.Student;
import com.example.studentManagement.repo.StudentRepo;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentByRollNumber(Integer rollNumber) {
        return studentRepo.findById(rollNumber);
    }

    public String removeStudentById(Integer rollNumber) {
        try{
            studentRepo.deleteById(rollNumber);
            return "Student Successfully removed";
        }catch (Exception ex){
            return "Error occurred while removing records";
        }
    }

    public Student updateStudentRecords(Student student) throws FileNotFoundException {
        Optional<Student> student1=studentRepo.findById(student.getRollNumber());
        if(student1.isPresent()){
            studentRepo.delete(student1.get());
            return studentRepo.save(student);
        }
        else {
            throw new FileNotFoundException("Student Record Not Found");
        }
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }
}
