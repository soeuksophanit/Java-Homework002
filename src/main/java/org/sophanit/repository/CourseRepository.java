package org.sophanit.repository;

import org.apache.ibatis.annotations.*;
import org.sophanit.model.Course;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("SELECT * FROM courses INNER JOIN student_course ON courses.course_id = student_course.course_id")
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

}
