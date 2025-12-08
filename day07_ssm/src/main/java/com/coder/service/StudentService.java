package com.coder.service;

import com.coder.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    void deleteStudent(Integer id);
    void updateStudent(Student student);
    Student getStudentById(Integer id);
    List<Student> getAllStudents();
}
