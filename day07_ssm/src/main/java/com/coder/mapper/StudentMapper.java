package com.coder.mapper;

import com.coder.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    //新增
    @Insert("insert into student(name,age,gender) values(#{name},#{age},#{gender})")
    void save(Student student);

    //删除
    @Delete("delete from student where id=#{id}")
    void deleteById(Integer id);

    //修改
    @Update("update student set name=#{name},age=#{age},gender=#{gender} where id=#{id}")
    void update(Student student);

    //id查询
    @Select("select * from student where id=#{id}")
    Student selectById(Integer id);

    //查询所有
    @Select("select * from student")
    List<Student> selectAll();
}
