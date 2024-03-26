package org.sophanit.repository;

import org.apache.ibatis.annotations.*;
import org.sophanit.model.Course;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("SELECT * FROM courses INNER JOIN instructors ON courses.course_id = instructors.instructor_id")
    @Results(
            id = "courseMapper",
            value = {
                    @Result(property = "courseId",column = "course_id"),
                    @Result(property = "courseName",column = "course_name")
            }
    )
    List<Course> getAllCourses();

    @Select("SELECT * FROM courses WHERE course_id = #{id}")
    @ResultMap("courseMapper")
    Course findCourseById(Integer id);

}
