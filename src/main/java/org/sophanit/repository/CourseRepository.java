package org.sophanit.repository;

import org.apache.ibatis.annotations.*;
import org.sophanit.model.Course;
import org.sophanit.model.request.CourseRequest;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("SELECT * FROM courses")
    @Results(
            id = "courseMapper",
            value = {
                    @Result(property = "courseId",column = "course_id"),
                    @Result(property = "courseName",column = "course_name"),
                    @Result(property = "instructor",column = "instructor_id",
                    many = @Many(select = "org.sophanit.repository.InstructorRepository.findInstructorById"))
            }
    )
    List<Course> getAllCourses();

    @Select("SELECT * FROM courses WHERE course_id = #{id}")
    @ResultMap("courseMapper")

    Course findCourseById(Integer id);


    @Select("INSERT INTO courses VALUES (Default,#{request.courseName},#{request.description},#{request.instructorId}) RETURNING course_id")
    Integer addNewCourse(@Param("request") CourseRequest courseRequest);

    @Select("UPDATE courses " +
            "SET course_name = #{courseRequest.courseName}" +
            ",description = #{courseRequest.description}," +
            " instructor_id= #{courseRequest.instructorId}" +
            " WHERE course_id= #{id} RETURNING course_id")
    Integer updateCourse(CourseRequest courseRequest,Integer id);

    @Select("SELECT c.course_id,c.course_name,c.description,c.instructor_id FROM student_course sc" +
            " INNER JOIN courses c on c.course_id = sc.course_id " +
            "WHERE sc.student_id = #{studentId}")
    @ResultMap("courseMapper")
    Course getStudentByCourseById(Integer studentId);


}
