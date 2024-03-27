package org.sophanit.repository;

import org.apache.ibatis.annotations.*;
import org.sophanit.model.Student;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("SELECT * FROM students INNER JOIN courses ON students.student_id = courses.course_id")
    @Results(
            id = "studentMapper",
            value = {
                    @Result(property = "studentId" ,column = "student_id"),
                    @Result(property = "studentName" ,column = "student_name"),
                    @Result(property = "phoneNumber" ,column = "phone_number"),
                    @Result(property = "courses",column = "course_id",
                    many = @Many(select = "org.sophanit.repository.CourseRepository.findCourseById"))
            }
    )
    List<Student> findAllStudents();

    @ResultMap("studentMapper")
    @Select("SELECT * FROM students INNER JOIN courses ON courses.course_id=students.student_id WHERE student_id=#{id}")
    Student findStudentById(Integer id);
}
