package org.sophanit.repository;

import org.apache.ibatis.annotations.*;
import org.sophanit.model.Student;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("SELECT * FROM students")
    @Results(
            id = "studentMapper",
            value = {
                    @Result(property = "studentId" ,column = "student_id"),
                    @Result(property = "studentName" ,column = "student_name"),
                    @Result(property = "phoneNumber" ,column = "phone_number"),
                    @Result(property = "courses",column = "student_id",
                    many = @Many(select = "org.sophanit.repository.CourseRepository.getStudentByCourseById"))
            }
    )

    List<Student> findAllStudents();

    @ResultMap("studentMapper")
    @Select("SELECT * FROM students  WHERE student_id=#{id}")
    Student findStudentById(Integer id);
}
