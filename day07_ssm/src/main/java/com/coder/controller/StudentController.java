package com.coder.controller;

import com.coder.entity.Student;
import com.coder.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    //跳转新增页面
    @GetMapping("/toAdd")
    public String toAdd() {
        return "student/add";
    }

    //执行新增
    @PostMapping("/add")
    public String add(Student student) {
        studentService.addStudent(student);
        return "redirect:/student/list";
    }

    //查询
    @GetMapping("/list")
    public String list(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/list";
    }

    //跳转修改页面
    @GetMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable Integer id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/update";
    }

    //修改
    @PostMapping("/update")
    public String update(Student student) {
        studentService.updateStudent(student);
        return "redirect:/student/list";
    }

    //删除
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }
}