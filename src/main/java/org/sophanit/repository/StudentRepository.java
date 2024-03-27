package org.sophanit.repository;

import org.apache.ibatis.annotations.*;
import org.sophanit.model.Student;
import org.sophanit.model.request.StudentRequest;

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
    @Select("SELECT * FROM students  WHERE student_id= #{id} ")
    Student findStudentById(Integer id);

    @Select("DELETE FROM students WHERE student_id= #{id} RETURNING student_id")
    Integer deleteStudentById(Integer id);

    @Select("INSERT INTO students VALUES (DEFAULT,#{request.studentName},#{request.email},#{request.phoneNumber}) RETURNING student_id")
    Integer addNewStudent(@Param("request") StudentRequest studentRequest);


    @Select("INSERT INTO student_course VALUES (DEFAULT,#{id},#{course_id})")
    void addCourseList(Integer id,Integer course_id);

    @Select("UPDATE students SET student_name= #{request.studentName},email= #{request.email}, phone_number= #{request.phoneNumber} WHERE student_id= #{id} RETURNING student_id")
    Integer updateStudent(Integer id,@Param("request") StudentRequest studentRequest);


    @Select("SELECT id FROM student_course WHERE student_id= #{id}")
    List<Integer> findOldCourseId(Integer id);


    @Select("UPDATE student_course SET course_id= #{new_id} WHERE id= #{old_id} AND student_id= #{id}")
    void updateCourse(Integer id,Integer old_id,Integer new_id);
}
