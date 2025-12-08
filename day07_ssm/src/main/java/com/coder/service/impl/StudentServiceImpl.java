package com.coder.service.impl;

import com.coder.entity.Student;
import com.coder.mapper.StudentMapper;
import com.coder.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public void addStudent(Student student) {
        studentMapper.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentMapper.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.update(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }
}
