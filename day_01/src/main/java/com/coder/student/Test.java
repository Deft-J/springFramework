package com.coder.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        Student student = (Student) ctx.getBean("student");
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        System.out.println(student);
        studentService.save();
    }
}
