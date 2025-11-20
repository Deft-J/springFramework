package com.coder.student;

public class StudentService {
    private  StudentDao studentDao;

    public void save(){
        studentDao.save();
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

}
