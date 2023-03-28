package com.example.studentManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    private Integer rollNumber;
    private String name;
    private Integer marks;
    private String grade;
}
