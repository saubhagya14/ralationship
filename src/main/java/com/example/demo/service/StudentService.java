package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentsRepo;

    public Student addStudent(Student student) {
        studentsRepo.save(student);
        return student;
    }
}
