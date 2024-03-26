package org.sophanit.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.sophanit.model.Student;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("SELECT * FROM students")
    @Result(property = "studentId" ,column = "student_id")
    @Result(property = "studentName" ,column = "student_name")
    @Result(property = "phoneNumber" ,column = "phone_number")
    List<Student> findAllStudents();
}
