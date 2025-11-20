package com.coder.bathStudent;

import java.util.List;

public class Bath {
    private List<Student> student;

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public void check() {
        for (Student student : student) {
            if ("男".equals(student.getGender())) {
                System.out.println(student.getName()+"\t"+student.getGender()+"\t"+"允许进入");
            } else {
                System.out.println(student.getName() +"\t"+student.getGender()+"\t"+"禁止进入");
            }
        }
    }
}
